/**
 * Практики #1-#2 по циклам while, do-while, break и continue.
 */
public class Task9 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        practice1InfiniteLoops();
        practice2BreakAndContinue();
    }

    /**
     * Практика #1
     * Тривиальные примеры бесконечных циклов while и do-while.
     */
    private static void practice1InfiniteLoops() {
        System.out.println("Практика #1");

        int whileCounter = 0;
        while (true) {
            System.out.println("Бесконечный while, итерация " + whileCounter);
            whileCounter++;

            // break добавлен, чтобы пример не завис навсегда.
            if (whileCounter == 3) {
                break;
            }
        }

        int doWhileCounter = 0;
        do {
            System.out.println("Бесконечный do-while, итерация " + doWhileCounter);
            doWhileCounter++;

            // break добавлен, чтобы пример не завис навсегда.
            if (doWhileCounter == 3) {
                break;
            }
        } while (true);

        /*
         * Чистые бесконечные варианты выглядели бы так:
         *
         * while (true) {
         *     // код
         * }
         *
         * do {
         *     // код
         * } while (true);
         */
        System.out.println();
    }

    /**
     * Практика #2
     * Пример использования break и continue с циклом.
     */
    private static void practice2BreakAndContinue() {
        System.out.println("Практика #2");

        for (int i = 1; i <= 10; i++) {
            if (i == 3) {
                System.out.println("i = 3 пропускаем через continue");
                continue;
            }

            if (i == 8) {
                System.out.println("i = 8 останавливаем цикл через break");
                break;
            }

            System.out.println("i = " + i);
        }

        System.out.println();
    }
}
