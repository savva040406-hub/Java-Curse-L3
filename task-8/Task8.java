/**
 * Практики #1-#2 по оператору switch.
 */
public class Task8 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    enum Day {
        MONDAY,
        TUESDAY
    }

    public static void main(String[] args) {
        practice1SwitchTypes();
        practice2MissingBreak();
    }

    /**
     * Практика #1
     * Какого типа может быть переменная в switch?
     *
     * В switch в Java можно использовать:
     * byte, short, char, int;
     * Byte, Short, Character, Integer;
     * enum;
     * String.
     *
     * Нельзя использовать long, float, double, boolean.
     */
    private static void practice1SwitchTypes() {
        System.out.println("Практика #1");

        byte byteValue = 1;
        switch (byteValue) {
            case 1:
                System.out.println("byte");
                break;
            default:
                break;
        }

        short shortValue = 1;
        switch (shortValue) {
            case 1:
                System.out.println("short");
                break;
            default:
                break;
        }

        char charValue = 'A';
        switch (charValue) {
            case 'A':
                System.out.println("char");
                break;
            default:
                break;
        }

        int intValue = 1;
        switch (intValue) {
            case 1:
                System.out.println("int");
                break;
            default:
                break;
        }

        Integer integerValue = 1;
        switch (integerValue) {
            case 1:
                System.out.println("Integer");
                break;
            default:
                break;
        }

        String stringValue = "java";
        switch (stringValue) {
            case "java":
                System.out.println("String");
                break;
            default:
                break;
        }

        Day day = Day.MONDAY;
        switch (day) {
            case MONDAY:
                System.out.println("enum");
                break;
            default:
                break;
        }

        System.out.println();
    }

    /**
     * Практика #2
     * Что произойдет, если в некоторых частях case будет отсутствовать break?
     *
     * Ответ:
     * произойдет fall-through — выполнение "провалится" в следующий case.
     * Java будет выполнять код следующего case до ближайшего break
     * или до конца switch.
     */
    private static void practice2MissingBreak() {
        System.out.println("Практика #2");

        int value = 1;
        int i = 0;

        switch (value) {
            case 1:
                i = 1;
                System.out.println("case 1, i = " + i);
                break;
            case 2:
                i = 2;
                System.out.println("case 2, i = " + i);
                // break отсутствует
            case 3:
                i = 3;
                System.out.println("case 3, i = " + i);
                break;
            default:
                System.out.println("default");
                break;
        }

        System.out.println("При value = 1 выполнение остановилось на break в case 1.");

        value = 2;
        switch (value) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                System.out.println("case 2 без break, i = " + i);
                // break нет, поэтому выполнение перейдет в case 3
            case 3:
                i = 3;
                System.out.println("case 3 после проваливания, i = " + i);
                break;
            default:
                break;
        }

        System.out.println("При value = 2 итоговое i = " + i);
        System.out.println();
    }
}
