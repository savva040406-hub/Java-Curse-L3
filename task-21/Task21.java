/**
 * Практика #1
 * Пример кода, демонстрирующего невозможность переопределить final-метод.
 */
public class Task21 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        FinalMethodChild child = new FinalMethodChild();
        child.printInfo();
        child.normalMethod();

        FinalClassExample example = new FinalClassExample();
        example.print();
    }
}

class FinalMethodParent {
    public final void printInfo() {
        System.out.println("Этот метод final, поэтому его нельзя переопределить.");
    }

    public void normalMethod() {
        System.out.println("Обычный метод суперкласса.");
    }
}

class FinalMethodChild extends FinalMethodParent {
    /*
    Ошибка компиляции:
    public void printInfo() {
        System.out.println("Попытка переопределения");
    }

    Причина: метод printInfo() в суперклассе объявлен как final.
    */

    @Override
    public void normalMethod() {
        System.out.println("Обычный метод можно переопределить.");
    }
}

/**
 * Практика #2
 * Пример кода, демонстрирующего невозможность наследования от final-класса.
 */
final class FinalClassExample {
    public void print() {
        System.out.println("От final-класса нельзя создать подкласс.");
    }
}

/*
Ошибка компиляции:
class ChildOfFinalClass extends FinalClassExample {
}

Причина: класс FinalClassExample объявлен как final.
*/
