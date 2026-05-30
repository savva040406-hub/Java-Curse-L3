import java.util.StringJoiner;

/**
 * Практика #1, #2, #3
 * Методы String, StringJoiner и текстовые блоки с тремя двойными кавычками.
 */
public class Task31 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String text = "  Java Programming Language  ";

        // 1. length() возвращает длину строки.
        System.out.println("length = " + text.length());

        // 2. trim() убирает пробелы в начале и конце строки.
        System.out.println("trim = '" + text.trim() + "'");

        // 3. toUpperCase() переводит строку в верхний регистр.
        System.out.println(text.toUpperCase());

        // 4. toLowerCase() переводит строку в нижний регистр.
        System.out.println(text.toLowerCase());

        // 5. contains() проверяет наличие подстроки.
        System.out.println(text.contains("Java"));

        // 6. startsWith() проверяет начало строки.
        System.out.println(text.trim().startsWith("Java"));

        // 7. endsWith() проверяет конец строки.
        System.out.println(text.trim().endsWith("Language"));

        // 8. substring() возвращает часть строки.
        System.out.println(text.trim().substring(0, 4));

        // 9. replace() заменяет символы или подстроки.
        System.out.println(text.replace("Java", "Kotlin"));

        // 10. split() разбивает строку на массив строк.
        String[] words = text.trim().split(" ");
        for (String word : words) {
            System.out.println(word);
        }

        useStringJoiner();
        explainTextBlocks();
    }

    /**
     * Практика #2
     * StringJoiner удобен, когда нужно собрать строку из частей с разделителем,
     * а также указать префикс и суффикс.
     */
    private static void useStringJoiner() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        joiner.add("Java");
        joiner.add("Python");
        joiner.add("C++");
        System.out.println(joiner);
    }

    /**
     * Практика #3
     * Три двойные кавычки в Java используются для text block.
     * Это удобно для многострочного текста, SQL-запросов, JSON, HTML и т.д.
     */
    private static void explainTextBlocks() {
        String json = """
                {
                    "language": "Java",
                    "level": 3
                }
                """;
        System.out.println(json);
    }
}
