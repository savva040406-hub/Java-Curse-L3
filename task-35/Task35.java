public class Task35 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Практика #1. Одно исключение перехвачено, второе приводит к аварийной остановке");
        caughtException();

        /*
         * Вызов notCaughtException() закомментирован, потому что он завершит программу исключением.
         * Раскомментируйте строку, чтобы увидеть аварийную остановку.
         */
        // notCaughtException();
    }

    private static void caughtException() {
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Исключение перехвачено: " + e.getClass().getSimpleName());
        }
    }

    private static void notCaughtException() {
        String text = null;
        System.out.println(text.length()); // NullPointerException не обрабатывается и поднимается вверх по стеку
    }
}
