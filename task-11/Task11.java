/**
 * Практика #1
 * Тема: спецификаторы доступа private, default, protected, public.
 *
 * В Java есть четыре уровня доступа:
 * 1. private — доступ только внутри того же класса.
 * 2. Без спецификатора, package-private — доступ только внутри того же пакета.
 * 3. protected — доступ внутри пакета, а также в классах-наследниках.
 * 4. public — доступ из любого класса и любого пакета.
 *
 */
class AccessExample {
    public String publicValue = "public: доступно везде";
    protected String protectedValue = "protected: доступно в пакете и наследниках";
    String defaultValue = "default: доступно только внутри пакета";
    private String privateValue = "private: доступно только внутри класса";

    public void publicMethod() {
        System.out.println(publicValue);
    }

    protected void protectedMethod() {
        System.out.println(protectedValue);
    }

    void defaultMethod() {
        System.out.println(defaultValue);
    }

    private void privateMethod() {
        System.out.println(privateValue);
    }

    public void showPrivateInsideClass() {
        privateMethod();
    }
}

class ChildAccessExample extends AccessExample {
    public void showAccessFromChild() {
        publicMethod();
        protectedMethod();
        defaultMethod();

        // privateMethod();
        // Ошибка компиляции: private-метод доступен только внутри AccessExample.
    }
}

public class Task11 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        AccessExample example = new AccessExample();

        example.publicMethod();
        example.protectedMethod();
        example.defaultMethod();
        example.showPrivateInsideClass();

        // example.privateMethod();
        // Ошибка компиляции: private-метод нельзя вызвать извне класса AccessExample.

        ChildAccessExample child = new ChildAccessExample();
        child.showAccessFromChild();
    }
}
