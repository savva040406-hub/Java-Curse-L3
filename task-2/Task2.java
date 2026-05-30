import java.util.Scanner;

/**
 * Практика #1
 *
 * Напишите программу, которая просит ввести имя и выводит на консоль строку:
 * "Привет, <введенное имя>".
 */
public class Task2 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.println("Привет, " + name);
    }
}
