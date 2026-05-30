public class Task34 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        explainMainExceptionClasses();
        demonstrateExceptions();
    }

    private static void explainMainExceptionClasses() {
        System.out.println("Практика #1. Основные классы исключений");
        /*
         * Throwable — общий суперкласс для всех объектов, которые можно бросать через throw.
         * Error — серьезные ошибки среды выполнения. Обычно их не обрабатывают в прикладном коде.
         * Exception — исключительные ситуации, которые приложение может обработать.
         * RuntimeException — ошибки времени выполнения, часто связанные с ошибками программиста.
         */
        System.out.println("Throwable -> Error / Exception -> RuntimeException");
    }

    private static void demonstrateExceptions() {
        System.out.println("\nПрактика #2. Генерация и обработка исключений");

        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: деление на ноль");
        }

        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: выход за границы массива");
        }

        try {
            setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            Class.forName("no.such.ClassName");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: класс не найден");
        }

        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: обращение к методу через null");
        }
    }

    private static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("возраст не может быть отрицательным");
        }
    }
}
