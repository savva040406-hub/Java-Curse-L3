/**
 * Практика #1
 * Все три варианта использования super:
 * 1) вызов конструктора суперкласса;
 * 2) доступ к полю суперкласса;
 * 3) доступ к методу суперкласса.
 */
public class Task22 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SuperChild child = new SuperChild("поле родителя", "поле потомка");
        child.showAllSuperUsages();

        CClass c = new CClass();
        c.method();

        ConstructorDemo demo = new ConstructorDemo(10, 20, 30);
        demo.print();
    }
}

class SuperParent {
    String text;

    SuperParent(String text) {
        this.text = text;
    }

    void printText() {
        System.out.println("Метод SuperParent: " + text);
    }
}

class SuperChild extends SuperParent {
    String text;

    SuperChild(String parentText, String childText) {
        super(parentText);       // 1. вызов конструктора суперкласса
        this.text = childText;
    }

    void showAllSuperUsages() {
        System.out.println("super.text = " + super.text); // 2. поле суперкласса
        super.printText();                               // 3. метод суперкласса
        System.out.println("this.text = " + this.text);
    }
}

/**
 * Практика #2
 * Что случится при вызове method() объекта класса C,
 * если переменная a и метод method() не определены в B, а есть только в A.
 *
 * Ответ: код сработает. Класс C наследует цепочку A -> B -> C.
 * Если в B нет поля a и метода method(), поиск продолжается выше по иерархии,
 * то есть в классе A. Поэтому super.a и super.method() из C обратятся к членам,
 * унаследованным B от A.
 */
class AClass {
    int a = 100;

    void method() {
        System.out.println("AClass.method(), a = " + a);
    }
}

class BClass extends AClass {
    // Здесь специально нет поля a и метода method().
}

class CClass extends BClass {
    @Override
    void method() {
        int a = super.a;
        System.out.println("super.a из C = " + a);
        super.method();
    }
}

/**
 * Практика #3
 * Переписанный код с использованием this().
 *
 * Вызов this(...) должен быть первым оператором в конструкторе.
 * Он нужен, чтобы не дублировать одинаковую инициализацию в разных конструкторах.
 */
class ConstructorDemo {
    int a;
    int b;
    int c;
    int z;

    public ConstructorDemo() {
        this(0, 0, 0);
    }

    public ConstructorDemo(int a) {
        this(a, 0, 0);
    }

    public ConstructorDemo(int a, int b) {
        this(a, b, 0);
    }

    public ConstructorDemo(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.z = 1;
    }

    void print() {
        System.out.println("a=" + a + ", b=" + b + ", c=" + c + ", z=" + z);
    }
}
