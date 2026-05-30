/**
 * Практика #1
 * Пример перегруженных методов.
 */
public class Task23 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        OverloadExample overload = new OverloadExample();
        overload.print(10);
        overload.print("Java");
        overload.print(10, "Java");

        Animal animal = new Dog();
        animal.voice(); // динамическое связывание: вызовется метод Dog

        OverrideMistakeFixed fixed = new OverrideMistakeFixed();
        fixed.print("text");
    }
}

class OverloadExample {
    void print(int value) {
        System.out.println("int: " + value);
    }

    void print(String value) {
        System.out.println("String: " + value);
    }

    void print(int number, String text) {
        System.out.println(number + " " + text);
    }
}

/**
 * Практика #2
 * Пример переопределенного метода.
 *
 * Если у переопределенного метода и метода суперкласса не совпадает тип
 * возвращаемого значения, это ошибка компиляции. Исключение — ковариантный
 * возвращаемый тип: подкласс может вернуть более конкретный тип.
 */
class Animal {
    Animal copy() {
        return new Animal();
    }

    void voice() {
        System.out.println("Животное издает звук");
    }
}

class Dog extends Animal {
    @Override
    Dog copy() { // можно: Dog является подклассом Animal
        return new Dog();
    }

    @Override
    void voice() {
        System.out.println("Собака лает");
    }

    /*
    Ошибка компиляции:
    @Override
    int copy() {
        return 1;
    }

    int не является ковариантным типом для Animal.
    */
}

/**
 * Практика #3
 * Когда @Override помогает найти ошибку.
 */
class OverrideMistakeParent {
    void print(String text) {
        System.out.println("Parent: " + text);
    }
}

class OverrideMistakeFixed extends OverrideMistakeParent {
    @Override
    void print(String text) {
        System.out.println("Child: " + text);
    }

    /*
    Если случайно написать другой параметр, @Override сразу покажет ошибку:

    @Override
    void print(Object text) {
        System.out.println(text);
    }

    Без @Override это был бы новый перегруженный метод, а не переопределение.
    */
}
