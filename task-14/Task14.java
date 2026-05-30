public class Task14 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(new InitInDeclaration().a);
        System.out.println(new InitInConstructor(20).a);
        System.out.println(new InitInBlock().a);
        System.out.println(new InitInEveryConstructor().a);
        System.out.println(new InitInEveryConstructor(50).a);
    }
}

// Вариант 1: инициализация сразу при объявлении.
class InitInDeclaration {
    public final int a = 10;
}

// Вариант 2: инициализация в конструкторе.
class InitInConstructor {
    public final int a;

    public InitInConstructor(int value) {
        a = value;
    }
}

// Вариант 3: инициализация в логическом блоке объекта.
class InitInBlock {
    public final int a;

    {
        a = 30;
    }
}

// Вариант 4: если конструкторов несколько, final-поле должно быть задано в каждом из них.
class InitInEveryConstructor {
    public final int a;

    public InitInEveryConstructor() {
        a = 40;
    }

    public InitInEveryConstructor(int value) {
        a = value;
    }
}
