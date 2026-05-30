public class Task37 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Практика #1. Собственный класс исключения");

        try {
            registerUser("Max", -1);
        } catch (InvalidUserDataException e) {
            System.out.println("Ошибка регистрации: " + e.getMessage());
        }
    }

    private static void registerUser(String name, int age) throws InvalidUserDataException {
        if (name == null || name.isBlank()) {
            throw new InvalidUserDataException("имя не может быть пустым");
        }
        if (age < 0) {
            throw new InvalidUserDataException("возраст не может быть отрицательным");
        }
        System.out.println("Пользователь зарегистрирован");
    }
}

class InvalidUserDataException extends Exception {
    public InvalidUserDataException() {
        super();
    }

    public InvalidUserDataException(String message) {
        super(message);
    }

    public InvalidUserDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
