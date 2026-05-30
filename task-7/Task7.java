/**
 * Практика #1
 * Запишите код через конструкцию ? :
 */
public class Task7 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int a = 2;

        int i = (a == 1) ? 1 : (a == 2) ? 2 : 3;

        System.out.println("i = " + i);

        /*
         * Исходный код:
         *
         * int i = 0;
         * if (a == 1) {
         *     i = 1;
         * } else if (a == 2) {
         *     i = 2;
         * } else {
         *     i = 3;
         * }
         *
         * Через тернарный оператор:
         *
         * int i = (a == 1) ? 1 : (a == 2) ? 2 : 3;
         */
    }
}
