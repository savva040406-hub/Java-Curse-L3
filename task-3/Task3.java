/**
 * Практики #1-#8 по типам данных, переменным, преобразованиям типов,
 * строкам и выводу Unicode-символов.
 */
public class Task3 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        practice1PrimitiveTypes();
        practice2UnicodeName();
        practice3Scope();
        practice4StringPlus();
        practice5MixedArithmetic();
        practice6Narrowing();
        practice7ByteTasks();
        practice8VarTypeInference();
    }

    /**
     * Практика #1
     * Приведите примеры для всех типов данных. Примеры должны также включать нулевые значения.
     */
    private static void practice1PrimitiveTypes() {
        System.out.println("Практика #1");

        byte byteValue = 10;
        byte byteZero = 0;

        short shortValue = 300;
        short shortZero = 0;

        int intValue = 1000;
        int intZero = 0;

        long longValue = 100000L;
        long longZero = 0L;

        float floatValue = 3.14F;
        float floatZero = 0.0F;

        double doubleValue = 12.56;
        double doubleZero = 0.0;

        char charValue = 'A';
        char charZero = '\u0000';

        boolean booleanValue = true;
        boolean booleanZero = false;

        System.out.println("byte: " + byteValue + ", zero: " + byteZero);
        System.out.println("short: " + shortValue + ", zero: " + shortZero);
        System.out.println("int: " + intValue + ", zero: " + intZero);
        System.out.println("long: " + longValue + ", zero: " + longZero);
        System.out.println("float: " + floatValue + ", zero: " + floatZero);
        System.out.println("double: " + doubleValue + ", zero: " + doubleZero);
        System.out.println("char: " + charValue + ", zero code: " + (int) charZero);
        System.out.println("boolean: " + booleanValue + ", zero/false: " + booleanZero);
        System.out.println();
    }

    /**
     * Практика #2
     * Напечатайте в консоли свое имя, используя символы в формате Unicode U+XXXX.
     */
    private static void practice2UnicodeName() {
        System.out.println("Практика #2");

        // Савва в Unicode:
        System.out.println("\u0421\u0430\u0432\u0432\u0430");
    }

    /**
     * Практика #3
     * Какое значение будет в переменной c после выполнения кода?
     *
     * int a = 1;
     * {
     *     int b = 2;
     * }
     * int c = a + b;
     *
     * Ответ:
     * значения в c не будет, потому что код не скомпилируется.
     * Переменная b объявлена внутри блока { }, поэтому она доступна только внутри этого блока.
     * После закрывающей скобки переменная b уже вне области видимости.
     */
    private static void practice3Scope() {
        System.out.println("Практика #3");

        int a = 1;
        {
            int b = 2;
            System.out.println("Внутри блока можно использовать b: " + b);
        }

        // int c = a + b; // Ошибка компиляции: cannot find symbol b

        int correctC = a + 2;
        System.out.println("Если b была бы доступна, результат был бы: " + correctC);
        System.out.println("Но исходный код не компилируется, потому что b вне области видимости.");
        System.out.println();
    }

    /**
     * Практика #4
     * Примеры использования перегруженного оператора + с объектами типа String
     * и переменными других типов.
     */
    private static void practice4StringPlus() {
        System.out.println("Практика #4");

        String name = "Савва";
        int age = 20;
        double height = 188.0;
        boolean isStudent = true;

        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Рост: " + height);
        System.out.println("Студент: " + isStudent);

        // Важно: если один из операндов String, то + выполняет конкатенацию.
        System.out.println("2 + 3 = " + 2 + 3);       // "2 + 3 = 23"
        System.out.println("2 + 3 = " + (2 + 3));     // "2 + 3 = 5"
        System.out.println();
    }

    /**
     * Практика #5
     * Примеры арифметических операций с переменными различных типов.
     */
    private static void practice5MixedArithmetic() {
        System.out.println("Практика #5");

        byte b = 10;
        short s = 20;
        int i = 30;
        long l = 40L;
        float f = 2.5F;
        double d = 3.5;

        int result1 = b + s;       // byte и short расширяются до int
        long result2 = i + l;      // int расширяется до long
        float result3 = l + f;     // long расширяется до float
        double result4 = f + d;    // float расширяется до double

        System.out.println("byte + short -> int: " + result1);
        System.out.println("int + long -> long: " + result2);
        System.out.println("long + float -> float: " + result3);
        System.out.println("float + double -> double: " + result4);
        System.out.println();
    }

    /**
     * Практика #6
     * Примеры сужающего преобразования типов.
     */
    private static void practice6Narrowing() {
        System.out.println("Практика #6");

        int intValue = 130;
        byte byteValue = (byte) intValue; // переполнение диапазона byte

        double doubleValue = 12.99;
        int intFromDouble = (int) doubleValue; // дробная часть отбрасывается

        long longValue = 1000L;
        short shortValue = (short) longValue;

        System.out.println("int 130 -> byte: " + byteValue);
        System.out.println("double 12.99 -> int: " + intFromDouble);
        System.out.println("long 1000 -> short: " + shortValue);
        System.out.println();
    }

    /**
     * Практика #7
     *
     * int a = 120;
     * byte b = a + 10;
     * byte c = (byte)(a + 10);
     * byte d = a + 1;
     *
     * Ответ:
     * byte b = a + 10; не скомпилируется, потому что выражение a + 10 имеет тип int.
     * Кроме того, 130 выходит за диапазон byte: от -128 до 127.
     *
     * byte c = (byte)(a + 10); скомпилируется, потому что есть явное приведение.
     * Значение будет -126 из-за переполнения byte.
     *
     * byte d = a + 1; не скомпилируется, потому что выражение a + 1 имеет тип int.
     */
    private static void practice7ByteTasks() {
        System.out.println("Практика #7");

        int a = 120;

        // byte b = a + 10; // Ошибка компиляции
        byte c = (byte) (a + 10);
        // byte d = a + 1; // Ошибка компиляции

        System.out.println("c = " + c);
        System.out.println("b и d не будут созданы, потому что эти строки не компилируются.");
        System.out.println();
    }

    /**
     * Практика #8
     * Type inference — это автоматический вывод типа переменной компилятором.
     * В Java для локальных переменных можно использовать var.
     */
    private static void practice8VarTypeInference() {
        System.out.println("Практика #8");

        var number = 10;          // компилятор понимает, что это int
        var text = "Java";        // компилятор понимает, что это String
        var price = 19.99;        // компилятор понимает, что это double
        var flag = true;          // компилятор понимает, что это boolean

        System.out.println("number = " + number);
        System.out.println("text = " + text);
        System.out.println("price = " + price);
        System.out.println("flag = " + flag);

        // var нельзя использовать без инициализации:
        // var x; // Ошибка компиляции
    }
}
