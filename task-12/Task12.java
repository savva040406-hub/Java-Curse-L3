public class Task12 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.sum(2, 3));
        System.out.println(calculator.sum(2.5, 3.1));
        System.out.println(calculator.sum(1, 2, 3));

        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.voice();
        dog.voice();
    }
}

class Calculator {
    // Перегрузка метода: одинаковое имя, но разные параметры.
    public int sum(int a, int b) {
        return a + b;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public int sum(int a, int b, int c) {
        return a + b + c;
    }
}

class Animal {
    public void voice() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    // Переопределение метода: подкласс дает свою реализацию метода суперкласса.
    @Override
    public void voice() {
        System.out.println("Dog barks");
    }
}
