import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task41 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Практика #1. Чтение данных из текстового файла через Scanner");

        if (args.length == 0) {
            System.out.println("Передайте путь к файлу первым аргументом командной строки.");
            System.out.println("Пример: java Task40 input.txt");
            return;
        }

        File file = new File(args[0]);
        try (Scanner scanner = new Scanner(file)) {
            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + file.getAbsolutePath());
        }
    }
}
