public class Task36 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        sameProcessing("abc", new int[]{1, 2, 3});
        hierarchyProcessing(0);
        hierarchyProcessing(1);
        hierarchyProcessing(2);
        explainFinalInCatch();
    }

    private static void sameProcessing(String text, int[] values) {
        System.out.println("Практика #1. Одинаковая обработка нескольких исключений");
        try {
            System.out.println(text.substring(10));
            System.out.println(values[20]);
        } catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка индекса: " + e.getClass().getSimpleName());
        }
    }

    private static void hierarchyProcessing(int variant) {
        System.out.println("\nПрактика #1. Обработка иерархии исключений");
        try {
            if (variant == 0) {
                throw new ChildException("исключение подкласса");
            } else if (variant == 1) {
                throw new ParentException("исключение суперкласса");
            } else {
                throw new Exception("общее исключение");
            }
        } catch (ChildException e) {
            System.out.println("Сначала обрабатывается самый конкретный тип: " + e.getMessage());
        } catch (ParentException e) {
            System.out.println("Затем суперкласс: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("В конце самый общий тип: " + e.getMessage());
        }
    }

    private static void explainFinalInCatch() {
        System.out.println("\nПрактика #2. final в catch");
        try {
            throw new Exception("пример");
        } catch (final Exception e) {
            /*
             * final означает, что переменную e нельзя переназначить внутри блока catch.
             * Например, строка e = new Exception(); вызвала бы ошибку компиляции.
             * Сам объект исключения при этом остается обычным объектом.
             */
            System.out.println("Переменную e нельзя переназначить: " + e.getMessage());
        }
    }

    private static class ParentException extends Exception {
        ParentException(String message) {
            super(message);
        }
    }

    private static class ChildException extends ParentException {
        ChildException(String message) {
            super(message);
        }
    }
}
