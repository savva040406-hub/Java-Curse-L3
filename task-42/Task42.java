import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Task42 {
    static {
        System.setOut(new java.io.PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setErr(new java.io.PrintStream(System.err, true, StandardCharsets.UTF_8));
    }

    private static final int MAGIC = 0x48554632;

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            usage();
            return;
        }

        Path input = Path.of(args[1]);
        Path output = Path.of(args[2]);

        if (args[0].equals("encode")) {
            encode(input, output);
            System.out.println("Файл закодирован");
        } else if (args[0].equals("decode")) {
            decode(input, output);
            System.out.println("Файл декодирован");
        } else {
            usage();
        }
    }

    private static void usage() {
        System.out.println("java Task42 encode inputFile outputFile");
        System.out.println("java Task42 decode inputFile outputFile");
    }

    private static void encode(Path inputFile, Path outputFile) throws IOException {
        byte[] data = Files.readAllBytes(inputFile);
        int[] freq = countFrequencies(data);
        Map<Byte, String> codes = new HashMap<>();

        if (data.length > 0) {
            Node root = buildTree(freq);
            buildCodes(root, "", codes);
        }

        try (DataOutputStream out = new DataOutputStream(Files.newOutputStream(outputFile))) {
            out.writeInt(MAGIC);
            out.writeInt(data.length);
            out.writeInt(codes.size());

            for (Map.Entry<Byte, String> entry : codes.entrySet()) {
                out.writeByte(entry.getKey());
                out.writeUTF(entry.getValue());
            }

            BitOutputStream bitOut = new BitOutputStream(out);
            for (byte b : data) {
                bitOut.writeCode(codes.get(b));
            }
            bitOut.flush();
        }
    }

    private static void decode(Path inputFile, Path outputFile) throws IOException {
        try (DataInputStream in = new DataInputStream(Files.newInputStream(inputFile));
             OutputStream out = Files.newOutputStream(outputFile)) {

            if (in.readInt() != MAGIC) {
                throw new IOException("Неверный формат файла");
            }

            int originalLength = in.readInt();
            int dictionarySize = in.readInt();
            DecodeNode root = new DecodeNode();

            for (int i = 0; i < dictionarySize; i++) {
                byte value = in.readByte();
                String code = in.readUTF();
                addCode(root, value, code);
            }

            BitInputStream bitIn = new BitInputStream(in);
            DecodeNode current = root;
            int written = 0;

            while (written < originalLength) {
                int bit = bitIn.readBit();
                if (bit == -1) {
                    throw new IOException("Файл поврежден");
                }

                current = bit == 0 ? current.left : current.right;
                if (current == null) {
                    throw new IOException("Файл поврежден");
                }

                if (current.isLeaf()) {
                    out.write(current.value);
                    written++;
                    current = root;
                }
            }
        }
    }

    private static int[] countFrequencies(byte[] data) {
        int[] freq = new int[256];
        for (byte b : data) {
            freq[b & 0xFF]++;
        }
        return freq;
    }

    private static Node buildTree(int[] freq) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                queue.add(new Node((byte) i, freq[i], null, null));
            }
        }

        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            queue.add(new Node((byte) 0, left.frequency + right.frequency, left, right));
        }
        return queue.poll();
    }

    private static void buildCodes(Node node, String code, Map<Byte, String> codes) {
        if (node.isLeaf()) {
            codes.put(node.value, code.isEmpty() ? "0" : code);
            return;
        }
        buildCodes(node.left, code + "0", codes);
        buildCodes(node.right, code + "1", codes);
    }

    private static void addCode(DecodeNode root, byte value, String code) {
        DecodeNode current = root;
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '0') {
                if (current.left == null) {
                    current.left = new DecodeNode();
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new DecodeNode();
                }
                current = current.right;
            }
        }
        current.value = value;
        current.hasValue = true;
    }

    private static class Node implements Comparable<Node> {
        private final byte value;
        private final int frequency;
        private final Node left;
        private final Node right;

        private Node(byte value, int frequency, Node left, Node right) {
            this.value = value;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        private boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.frequency, other.frequency);
        }
    }

    private static class DecodeNode {
        private DecodeNode left;
        private DecodeNode right;
        private byte value;
        private boolean hasValue;

        private boolean isLeaf() {
            return hasValue;
        }
    }

    private static class BitOutputStream {
        private final DataOutputStream out;
        private int currentByte;
        private int bitCount;

        private BitOutputStream(DataOutputStream out) {
            this.out = out;
        }

        private void writeCode(String code) throws IOException {
            for (int i = 0; i < code.length(); i++) {
                writeBit(code.charAt(i) == '1' ? 1 : 0);
            }
        }

        private void writeBit(int bit) throws IOException {
            currentByte = (currentByte << 1) | bit;
            bitCount++;
            if (bitCount == 8) {
                out.writeByte(currentByte);
                currentByte = 0;
                bitCount = 0;
            }
        }

        private void flush() throws IOException {
            if (bitCount > 0) {
                currentByte <<= (8 - bitCount);
                out.writeByte(currentByte);
            }
        }
    }

    private static class BitInputStream {
        private final InputStream in;
        private int currentByte;
        private int bitIndex = 8;

        private BitInputStream(InputStream in) {
            this.in = in;
        }

        private int readBit() throws IOException {
            if (bitIndex == 8) {
                currentByte = in.read();
                if (currentByte == -1) {
                    return -1;
                }
                bitIndex = 0;
            }
            int bit = (currentByte >> (7 - bitIndex)) & 1;
            bitIndex++;
            return bit;
        }
    }
}
