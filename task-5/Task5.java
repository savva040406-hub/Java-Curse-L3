/**
 * Практики #1-#2 по операторам Java.
 */
public class Task5 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        practice1Operators();
        practice2Instanceof();
    }

    /**
     * Практика #1
     * Примеры использования операторов с базовыми типами и String.
     * Для ++ и -- показаны префиксная и постфиксная формы.
     */
    private static void practice1Operators() {
        System.out.println("Практика #1");

        int a = 10;
        int b = 3;

        System.out.println("a = " + a + ", b = " + b);

        // Арифметические операторы
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        // Операторы присваивания
        int c = a;
        c += b;
        System.out.println("c += b -> " + c);
        c -= b;
        System.out.println("c -= b -> " + c);
        c *= b;
        System.out.println("c *= b -> " + c);
        c /= b;
        System.out.println("c /= b -> " + c);
        c %= b;
        System.out.println("c %= b -> " + c);

        // Инкремент и декремент
        int x = 5;
        System.out.println("x++ = " + x++); // сначала вывод, потом увеличение
        System.out.println("после x++: " + x);

        int y = 5;
        System.out.println("++y = " + ++y); // сначала увеличение, потом вывод
        System.out.println("после ++y: " + y);

        int m = 5;
        System.out.println("m-- = " + m--);
        System.out.println("после m--: " + m);

        int n = 5;
        System.out.println("--n = " + --n);
        System.out.println("после --n: " + n);

        // Логические операторы
        boolean p = true;
        boolean q = false;
        System.out.println("p && q = " + (p && q));
        System.out.println("p || q = " + (p || q));
        System.out.println("!p = " + (!p));

        // Операторы сравнения
        System.out.println("a == b = " + (a == b));
        System.out.println("a != b = " + (a != b));
        System.out.println("a > b = " + (a > b));
        System.out.println("a >= b = " + (a >= b));
        System.out.println("a < b = " + (a < b));
        System.out.println("a <= b = " + (a <= b));

        // Побитовые операторы
        System.out.println("a & b = " + (a & b));
        System.out.println("a | b = " + (a | b));
        System.out.println("a ^ b = " + (a ^ b));
        System.out.println("~a = " + (~a));
        System.out.println("a << 1 = " + (a << 1));
        System.out.println("a >> 1 = " + (a >> 1));
        System.out.println("a >>> 1 = " + (a >>> 1));

        // Тернарный оператор
        String result = a > b ? "a больше b" : "a не больше b";
        System.out.println(result);

        // Оператор + со String
        String text = "Java";
        System.out.println(text + " " + 17);
        System.out.println("Сумма: " + a + b);       // конкатенация: "Сумма: 103"
        System.out.println("Сумма: " + (a + b));     // арифметика: "Сумма: 13"

        System.out.println();
    }

    /**
     * Практика #2
     * Примеры использования instanceof, включая null.
     */
    private static void practice2Instanceof() {
        System.out.println("Практика #2");

        Object text = "Hello";
        Object number = Integer.valueOf(10);
        Object nullObject = null;

        System.out.println("text instanceof String = " + (text instanceof String));
        System.out.println("text instanceof Object = " + (text instanceof Object));
        System.out.println("number instanceof Integer = " + (number instanceof Integer));
        System.out.println("number instanceof Number = " + (number instanceof Number));

        // Для null оператор instanceof всегда возвращает false.
        System.out.println("nullObject instanceof String = " + (nullObject instanceof String));

        System.out.println();
    }
}
