import java.util.Scanner;

public class ConsoleGreetingPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.println("Привет, " + name);
    }
}
