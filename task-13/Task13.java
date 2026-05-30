public class Task13 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // Вариант 1: основной способ вызова статического метода.
        A.printVars();

        // Вариант 2: вызов через объект.
        A object = new A();
        object.printVars();

        // Вариант 3: вызов через null-ссылку.
        A nullObject = null;
        nullObject.printVars();

        // Вариант 4: вызов из метода того же класса без имени класса.
        A.callInsideClass();

        // Вариант 5: вызов через имя подкласса. Метод все равно принадлежит классу A.
        B.printVars();
    }
}

class A {
    public static int a = 1;
    public static int b;

    public static void printVars() {
        System.out.println(a);
        System.out.println(b);
    }

    public static void callInsideClass() {
        printVars();
    }
}

class B extends A {
}
