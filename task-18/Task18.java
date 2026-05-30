public class Task18 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Практика #1: Методы с переменным числом параметров\n");
        Printer printer = new Printer();

        printer.print(new int[]{}); // пустой набор int-аргументов
        printer.print(1);
        printer.print(1, 2, 3);
        printer.print("Numbers", 10, 20, 30);
        printer.print("Hello", "Java", "World");
    }
}

class Printer {
    public void print(int... numbers) {
        System.out.println("int...");
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public void print(String title, int... numbers) {
        System.out.println(title);
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public void print(String... words) {
        System.out.println("String...");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
