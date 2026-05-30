/**
 * Практики #1-#4 по классам-оболочкам.
 */
public class Task6 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        practice1Decode();
        practice2BooleanCreation();
        practice3BoxingUnboxingNpe();
        practice4IntegerCache();
    }

    /**
     * Практика #1
     * Примеры использования метода decode().
     */
    private static void practice1Decode() {
        System.out.println("Практика #1");

        Integer decimal = Integer.decode("12");
        Integer negative = Integer.decode("-12");
        Integer hex1 = Integer.decode("0x12");
        Integer hex2 = Integer.decode("#12");
        Integer octal = Integer.decode("012");

        System.out.println("Integer.decode(\"12\") = " + decimal);
        System.out.println("Integer.decode(\"-12\") = " + negative);
        System.out.println("Integer.decode(\"0x12\") = " + hex1);
        System.out.println("Integer.decode(\"#12\") = " + hex2);
        System.out.println("Integer.decode(\"012\") = " + octal);

        Long longHex = Long.decode("0xFF");
        Byte byteValue = Byte.decode("127");

        System.out.println("Long.decode(\"0xFF\") = " + longHex);
        System.out.println("Byte.decode(\"127\") = " + byteValue);
        System.out.println();
    }

    /**
     * Практика #2
     * Все основные способы создания экземпляра класса Boolean.
     */
    private static void practice2BooleanCreation() {
        System.out.println("Практика #2");

        Boolean b1 = Boolean.TRUE;
        Boolean b2 = Boolean.FALSE;
        Boolean b3 = Boolean.valueOf(true);
        Boolean b4 = Boolean.valueOf(false);
        Boolean b5 = Boolean.valueOf("true");
        Boolean b6 = Boolean.valueOf("false");
        Boolean b7 = Boolean.parseBoolean("true");

        System.out.println("Boolean.TRUE = " + b1);
        System.out.println("Boolean.FALSE = " + b2);
        System.out.println("Boolean.valueOf(true) = " + b3);
        System.out.println("Boolean.valueOf(false) = " + b4);
        System.out.println("Boolean.valueOf(\"true\") = " + b5);
        System.out.println("Boolean.valueOf(\"false\") = " + b6);
        System.out.println("Boolean.parseBoolean(\"true\") = " + b7);
        System.out.println();
    }

    /**
     * Практика #3
     * В каком случае при автоупаковке/автораспаковке будет брошено NullPointerException?
     *
     * Ответ:
     * NullPointerException появляется при автораспаковке null.
     * То есть когда объект-оболочка равен null, а Java пытается получить
     * из него значение базового типа.
     */
    private static void practice3BoxingUnboxingNpe() {
        System.out.println("Практика #3");

        Integer value = null;

        try {
            int number = value; // unboxing null -> NullPointerException
            System.out.println(number);
        } catch (NullPointerException exception) {
            System.out.println("При автораспаковке null возникло NullPointerException");
        }

        // Автоупаковка обычного значения безопасна:
        int primitive = 10;
        Integer boxed = primitive; // boxing
        System.out.println("Автоупаковка int в Integer: " + boxed);
        System.out.println();
    }

    /**
     * Практика #4
     * Какие значения напечатает код? Для чего используется IntegerCache?
     *
     * IntegerCache хранит заранее созданные объекты Integer для значений
     * обычно от -128 до 127. Поэтому при автоупаковке таких значений Java может
     * вернуть один и тот же объект из кэша.
     *
     */
    private static void practice4IntegerCache() {
        System.out.println("Практика #4");

        int i1 = 128;
        Integer a1 = 11;
        Integer b1 = i1;
        System.out.println("a1==11  " + (a1 == 11));
        System.out.println("b1==i1  " + (b1 == i1));
        System.out.println("a1==b1  " + (a1 == b1));
        System.out.println("a1.equals(i1) -> " + a1.equals(i1));
        System.out.println("b1.equals(i1) -> " + b1.equals(i1));
        System.out.println("a1.equals(b1) -> " + a1.equals(b1));

        int i2 = 127;
        Integer a2 = 12;
        Integer b2 = i2;
        System.out.println("a2==i2  " + (a2 == i2));
        System.out.println("b2==i2  " + (b2 == i2));
        System.out.println("a2==b2  " + (a2 == b2));
        System.out.println("a2.equals(i2) -> " + a2.equals(i2));
        System.out.println("b2.equals(i2) -> " + b2.equals(i2));
        System.out.println("a2.equals(b2) -> " + a2.equals(b2));

        // Отдельный пример IntegerCache:
        Integer cache1 = 127;
        Integer cache2 = 127;
        Integer noCache1 = 128;
        Integer noCache2 = 128;

        System.out.println("127 == 127 для Integer: " + (cache1 == cache2));
        System.out.println("128 == 128 для Integer: " + (noCache1 == noCache2));
        System.out.println();
    }
}
