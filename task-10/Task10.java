import java.util.Arrays;

/**
 * Практики #1-#2 по массивам и классу java.util.Arrays.
 */
public class Task10 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        practice1ArrayReferences();
        practice2ArraysClass();
    }

    /**
     * Практика #1
     * Что произойдет в результате выполнения кода?
     *
     * int a1[] = {1,2,3,4,5};
     * int a2[] = {6,7,8,9,10};
     * a1 = a2;
     *
     * Ответ:
     * переменная a1 начнет ссылаться на тот же массив, что и a2.
     * Старый массив {1,2,3,4,5} больше не будет доступен через a1.
     * Теперь изменение a1 будет менять тот же массив, который виден через a2.
     */
    private static void practice1ArrayReferences() {
        System.out.println("Практика #1");

        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {6, 7, 8, 9, 10};

        a1 = a2;

        System.out.println("a1 = " + Arrays.toString(a1));
        System.out.println("a2 = " + Arrays.toString(a2));

        a1[0] = 100;

        System.out.println("После a1[0] = 100:");
        System.out.println("a1 = " + Arrays.toString(a1));
        System.out.println("a2 = " + Arrays.toString(a2));
        System.out.println("a1 и a2 ссылаются на один массив: " + (a1 == a2));
        System.out.println();
    }

    /**
     * Практика #2
     * Примеры методов класса java.util.Arrays:
     * String toString(...)
     * int binarySearch(...)
     * boolean equals(...)
     * boolean compare(...)
     * void sort(...)
     */
    private static void practice2ArraysClass() {
        System.out.println("Практика #2");

        int[] numbers = {5, 3, 9, 1, 7};
        int[] sameNumbers = {5, 3, 9, 1, 7};
        int[] otherNumbers = {1, 3, 5, 7, 9};

        System.out.println("Arrays.toString(numbers): " + Arrays.toString(numbers));

        System.out.println("Arrays.equals(numbers, sameNumbers): "
                + Arrays.equals(numbers, sameNumbers));

        System.out.println("Arrays.compare(numbers, otherNumbers): "
                + Arrays.compare(numbers, otherNumbers));

        Arrays.sort(numbers);
        System.out.println("После Arrays.sort(numbers): " + Arrays.toString(numbers));

        int index = Arrays.binarySearch(numbers, 7);
        System.out.println("Arrays.binarySearch(numbers, 7): " + index);

        int missingIndex = Arrays.binarySearch(numbers, 4);
        System.out.println("Arrays.binarySearch(numbers, 4): " + missingIndex);

        System.out.println();
    }
}
