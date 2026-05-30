/**
 * Практика #1
 * Изучите утилиту javac и научитесь ею пользоваться.
 *
 * javac — это компилятор Java.
 * Он преобразует файл .java в байт-код .class.
 *
 * Пример использования в консоли:
 *
 * 1. Скомпилировать файл:
 *    javac Task4.java
 *
 * 2. Запустить программу:
 *    java Task4
 *
 * 3. Указать кодировку, если в файле есть русский текст:
 *    javac -encoding UTF-8 Task4.java
 *
 * 4. Скомпилировать несколько файлов:
 *    javac First.java Second.java
 *
 * 5. Скомпилировать все Java-файлы в папке:
 *    javac *.java
 *
 */
public class Task4 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Главный метод программы.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Это однострочный комментарий.
        System.out.println("Пример работы javac");

        /*
         * Это блочный комментарий.
         * Он может занимать несколько строк.
         */
        printMessage("Файл успешно скомпилирован и запущен.");
    }

    /**
     * Печатает сообщение в консоль.
     *
     * @param message текст сообщения
     */
    private static void printMessage(String message) {
        System.out.println(message);
    }
}
