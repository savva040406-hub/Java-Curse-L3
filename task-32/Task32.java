/**
 * Практика #1 и #2
 * StringBuilder, StringBuffer и преобразования между String, StringBuilder,
 * StringBuffer.
 */
public class Task32 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        demonstrateStringBuilder();
        demonstrateStringBuffer();
        demonstrateConversions();
    }

    private static void demonstrateStringBuilder() {
        StringBuilder builder = new StringBuilder("Java");

        // 1. append() добавляет данные в конец.
        builder.append(" language");

        // 2. insert() вставляет данные по индексу.
        builder.insert(0, "Best ");

        // 3. replace() заменяет часть строки.
        builder.replace(0, 4, "Powerful");

        // 4. delete() удаляет часть строки.
        builder.delete(0, 9);

        // 5. reverse() разворачивает строку.
        builder.reverse();
        builder.reverse();

        // 6. charAt() возвращает символ по индексу.
        System.out.println("charAt(0) = " + builder.charAt(0));

        // 7. setCharAt() меняет символ по индексу.
        builder.setCharAt(0, 'j');

        // 8. length() возвращает длину.
        System.out.println("length = " + builder.length());

        // 9. capacity() возвращает текущую емкость буфера.
        System.out.println("capacity = " + builder.capacity());

        // 10. toString() преобразует объект в String.
        String result = builder.toString();
        System.out.println(result);
    }

    private static void demonstrateStringBuffer() {
        StringBuffer buffer = new StringBuffer("Thread-safe");
        buffer.append(" buffer");
        buffer.insert(0, "StringBuffer: ");
        buffer.replace(0, 13, "Buffer object: ");
        buffer.delete(buffer.length() - 6, buffer.length());
        buffer.reverse();
        buffer.reverse();
        System.out.println(buffer.charAt(0));
        buffer.setCharAt(0, 'b');
        System.out.println(buffer.length());
        System.out.println(buffer.capacity());
        System.out.println(buffer.toString());
    }

    /**
     * Практика #2
     * Преобразования между String, StringBuilder и StringBuffer.
     */
    private static void demonstrateConversions() {
        String string = "Java";

        StringBuilder builderFromString = new StringBuilder(string);
        StringBuffer bufferFromString = new StringBuffer(string);

        String stringFromBuilder = builderFromString.toString();
        String stringFromBuffer = bufferFromString.toString();

        StringBuilder builderFromBuffer = new StringBuilder(bufferFromString.toString());
        StringBuffer bufferFromBuilder = new StringBuffer(builderFromString.toString());

        System.out.println(stringFromBuilder);
        System.out.println(stringFromBuffer);
        System.out.println(builderFromBuffer);
        System.out.println(bufferFromBuilder);
    }
}
