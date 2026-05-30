import java.util.ArrayList;
import java.util.List;

public class Task17 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Практика #1: instanceof с параметризованными классами");
        Box<String> stringBox = new Box<>("text");
        Box<Integer> integerBox = new Box<>(100);
        String text = "hello";

        System.out.println(stringBox instanceof Box<?>);      // true
        System.out.println(integerBox instanceof Box<?>);     // true
        System.out.println(text instanceof String);           // true
        System.out.println(stringBox.getValue() instanceof String);   // true
        System.out.println(integerBox.getValue() instanceof Integer); // true

        // Так писать нельзя: generic-тип стирается во время выполнения.
        // System.out.println(stringBox instanceof Box<String>);
        // System.out.println(integerBox instanceof Box<Integer>);

        System.out.println("\nПрактика #2: <? extends T> и <? super T>");
        List<Integer> integers = List.of(1, 2, 3);
        List<Double> doubles = List.of(1.5, 2.5);

        printNumbers(integers);
        printNumbers(doubles);

        List<Number> numbers = new ArrayList<>();
        addIntegers(numbers);
        System.out.println(numbers);

        List<Object> objects = new ArrayList<>();
        addIntegers(objects);
        System.out.println(objects);
    }

    // <? extends Number> значит: список содержит Number или наследников Number.
    // Из такого списка удобно читать элементы как Number.
    // Но добавлять конкретные значения нельзя, потому что неизвестен точный тип списка.
    public static void printNumbers(List<? extends Number> list) {
        for (Number number : list) {
            System.out.println(number);
        }
    }

    // <? super Integer> значит: список принимает Integer или его предков.
    // В такой список можно добавлять Integer.
    public static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }
}

class Box<T> {
    private final T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

/*
Практика #2
Зачем нужны конструкции <? extends T> и <? super T>?

<? extends T> используют, когда метод в основном читает данные.
Например, List<? extends Number> может принять List<Integer>, List<Double>, List<Float>.
Это удобно, если методу нужно работать с разными числовыми списками.

<? super T> используют, когда метод добавляет данные.
Например, List<? super Integer> может принять List<Integer>, List<Number>, List<Object>.
В такой список можно безопасно добавить Integer.

*/
