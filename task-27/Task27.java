/**
 * Практика #1
 * Пример вложенного static-класса в классе и в интерфейсе.
 */
public class Task27 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        OuterClass.NestedClass nested = new OuterClass.NestedClass();
        nested.printStaticOuterField();

        InterfaceWithNested.NestedInInterface nestedInInterface = new InterfaceWithNested.NestedInInterface();
        nestedInInterface.print();
    }
}

class OuterClass {
    static String staticOuterField = "static поле внешнего класса";
    String nonStaticOuterField = "нестатическое поле внешнего класса";

    static class NestedClass {
        void printStaticOuterField() {
            System.out.println(staticOuterField);
            // System.out.println(nonStaticOuterField); // нельзя без объекта OuterClass
            OuterClass outer = new OuterClass();
            System.out.println(outer.nonStaticOuterField); // можно через объект
        }
    }
}

interface InterfaceWithNested {
    /**
     * Класс внутри интерфейса неявно является public static.
     */
    class NestedInInterface {
        public void print() {
            System.out.println("Вложенный класс внутри интерфейса");
        }
    }
}
