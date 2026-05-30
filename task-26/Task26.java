/**
 * Практика #1, #2, #3
 * Примеры внутренних классов, доступа внутреннего класса к внешнему
 * и доступа внешнего класса к внутреннему.
 */
public class Task26 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        OuterForAccess outer = new OuterForAccess();

        OuterForAccess.PublicInner publicInner = outer.new PublicInner();
        publicInner.print();

        OuterForAccess.ProtectedInner protectedInner = outer.new ProtectedInner();
        protectedInner.print();

        OuterForAccess.PackageInner packageInner = outer.new PackageInner();
        packageInner.print();

        outer.createPrivateInner();
        outer.showInnerPrivateData();
    }
}

class OuterForAccess {
    private String privateOuterField = "private поле внешнего класса";
    public String publicOuterField = "public поле внешнего класса";

    /**
     * Практика #1
     * public-внутренний класс можно использовать снаружи, если доступен внешний класс.
     */
    public class PublicInner {
        public void print() {
            System.out.println("PublicInner");
        }
    }

    /**
     * protected-внутренний класс доступен в том же пакете и в подклассах.
     */
    protected class ProtectedInner {
        public void print() {
            System.out.println("ProtectedInner");
        }
    }

    /**
     * Внутренний класс без спецификатора доступен только в том же пакете.
     */
    class PackageInner {
        public void print() {
            System.out.println("PackageInner");
        }
    }

    /**
     * private-внутренний класс доступен только внутри внешнего класса.
     */
    private class PrivateInner {
        private String privateInnerField = "private поле внутреннего класса";

        void printOuterFields() {
            // Практика #2: внутренний класс имеет доступ даже к private-полям внешнего.
            System.out.println(privateOuterField);
            System.out.println(publicOuterField);
        }
    }

    void createPrivateInner() {
        PrivateInner inner = new PrivateInner();
        inner.printOuterFields();
    }

    void showInnerPrivateData() {
        // Практика #3: внешний класс имеет доступ к private-полям внутреннего,
        // но только через объект внутреннего класса.
        PrivateInner inner = new PrivateInner();
        System.out.println(inner.privateInnerField);
    }
}
