import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Task40 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        inputStreamReadExample();
        outputStreamWriteExample();
        explainReaderWriterHierarchy();
        autoCloseableExample();
    }

    private static void inputStreamReadExample() throws IOException {
        System.out.println("Практика #1. InputStream и read()");
        byte[] data = "ABC".getBytes(StandardCharsets.UTF_8);

        try (ByteArrayInputStream input = new ByteArrayInputStream(data)) {
            int value;
            while ((value = input.read()) != -1) {
                System.out.println("Прочитан байт: " + value + ", символ: " + (char) value);
            }
        }
    }

    private static void outputStreamWriteExample() throws IOException {
        System.out.println("\nПрактика #2. OutputStream и write(int)");

        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            output.write(72); // H
            output.write(105); // i
            output.write(33); // !
            String result = output.toString(StandardCharsets.UTF_8);
            System.out.println(result);
        }
    }

    private static void explainReaderWriterHierarchy() {
        System.out.println("\nПрактика #3. Зачем нужны Reader и Writer");
        /*
         * InputStream и OutputStream работают с байтами. Это удобно для бинарных данных:
         * картинок, архивов, class-файлов.
         * Reader и Writer работают с символами. Они учитывают кодировку текста и позволяют читать
         * или писать именно символы, а не отдельные байты. Поэтому для текстовых файлов они удобнее.
         */
        System.out.println("Reader/Writer нужны для символьного ввода-вывода с учетом кодировки.");
    }

    private static void autoCloseableExample() throws IOException {
        System.out.println("\nПрактика #4. AutoCloseable");
        /*
         * AutoCloseable позволяет объекту автоматически закрываться в try-with-resources.
         * Это помогает не забыть освободить ресурс: файл, поток, сетевое соединение.
         */
        try (ByteArrayInputStream input = new ByteArrayInputStream("Java".getBytes(StandardCharsets.UTF_8))) {
            System.out.println("Первый байт: " + input.read());
        }
    }
}
