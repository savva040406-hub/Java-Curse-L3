/**
 * Практика #1 и #2
 * default-методы, static-методы интерфейса и одинаковые методы в двух интерфейсах.
 */
public class Task30 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Worker worker = new WorkerImpl();

        // Вызов абстрактного метода через объект класса.
        worker.work();

        // Вызов default-метода через объект класса.
        worker.printInfo();

        // Вызов static-метода только через имя интерфейса.
        Worker.printStaticInfo();

        ConflictResolver resolver = new ConflictResolver();
        resolver.action();
    }
}

interface Worker {
    void work();

    default void printInfo() {
        System.out.println("default-метод интерфейса Worker");
    }

    static void printStaticInfo() {
        System.out.println("static-метод интерфейса Worker");
    }
}

class WorkerImpl implements Worker {
    @Override
    public void work() {
        System.out.println("Класс реализует абстрактный метод work()");
    }
}

/**
 * Практика #2
 * Если класс реализует два интерфейса с одинаковыми абстрактными методами,
 * конфликта нет: класс просто дает одну реализацию этого метода.
 *
 * Если одинаковыми будут default-методы, класс обязан переопределить метод
 * и явно решить конфликт.
 */
interface FirstInterface {
    void action();

    default void defaultAction() {
        System.out.println("FirstInterface.defaultAction()");
    }
}

interface SecondInterface {
    void action();

    default void defaultAction() {
        System.out.println("SecondInterface.defaultAction()");
    }
}

class ConflictResolver implements FirstInterface, SecondInterface {
    @Override
    public void action() {
        System.out.println("Одна реализация одинакового абстрактного метода action()");
    }

    @Override
    public void defaultAction() {
        FirstInterface.super.defaultAction();
        SecondInterface.super.defaultAction();
        System.out.println("Конфликт default-методов решен в классе");
    }
}
