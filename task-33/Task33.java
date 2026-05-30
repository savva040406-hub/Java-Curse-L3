import java.util.Formatter;
import java.util.Locale;

public class Task33 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        practice1BasicSpecifiers();
        practice2FlushExplanation();
        practice3DateTimeSpecifiers();
    }

    private static void practice1BasicSpecifiers() {
        System.out.println("Практика #1. Пять спецификаторов форматирования");

        Formatter formatter = new Formatter(System.out, Locale.US);
        formatter.format("boolean: %b%n", true);              // %b — логическое значение
        formatter.format("char: %c%n", 'A');                 // %c — символ
        formatter.format("integer: %d%n", 125);              // %d — десятичное целое число
        formatter.format("float: %.2f%n", 12.34567);         // %f — число с плавающей точкой
        formatter.format("string: %s%n", "Java");            // %s — строковое представление
        formatter.format("hash code: %h%n", "Java");         // %h — хэшкод аргумента в шестнадцатеричном виде
        formatter.format("percent: 100%%%n");                // %% — символ процента
        formatter.flush();
    }

    private static void practice2FlushExplanation() {
        System.out.println("\nПрактика #2. Зачем нужен flush()");
        /*
         * Метод flush() принудительно отправляет накопленные данные из буфера в конечный поток.
         * Форматтер может писать данные не сразу, а сначала держать их во внутреннем буфере.
         * Если программа завершится или поток закроется раньше, часть данных может не успеть попасть
         * в консоль, файл или сетевое соединение. Поэтому flush() используют, когда нужно быть уверенным,
         * что все уже записано.
         */
        System.out.println("flush() нужен, чтобы принудительно сбросить буфер вывода.");
    }

    private static void practice3DateTimeSpecifiers() {
        System.out.println("\nПрактика #3. Пять спецификаторов даты и времени");

        Formatter formatter = new Formatter(System.out, Locale.US);
        long now = System.currentTimeMillis();
        formatter.format("hour 00-23: %tH%n", now);          // %tH — час в формате 00-23
        formatter.format("minute: %tM%n", now);              // %tM — минуты 00-59
        formatter.format("second: %tS%n", now);              // %tS — секунды 00-59
        formatter.format("year: %tY%n", now);                // %tY — год в четырехзначном формате
        formatter.format("month name: %tB%n", now);          // %tB — полное название месяца
        formatter.format("day name: %tA%n", now);            // %tA — полное название дня недели
        formatter.flush();
    }
}
