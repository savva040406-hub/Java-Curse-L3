import java.util.Objects;

/**
 * Практика #1
 * Класс с переопределенным методом equals().
 *
 * Соглашения для equals():
 * 1. Рефлексивность: x.equals(x) == true.
 * 2. Симметричность: если x.equals(y), то y.equals(x).
 * 3. Транзитивность: если x.equals(y) и y.equals(z), то x.equals(z).
 * 4. Постоянство: результат не должен меняться, пока не меняются поля объекта.
 * 5. Сравнение с null всегда возвращает false.
 * 6. Если equals() переопределен, обычно нужно переопределить hashCode().
 */
public class Task25 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("Ivan", 20);
        Person p2 = new Person("Ivan", 20);
        Person p3 = new Person("Petr", 25);

        System.out.println(p1.equals(p1));   // true
        System.out.println(p1.equals(p2));   // true
        System.out.println(p1.equals(p3));   // false
        System.out.println(p1.equals(null)); // false
        System.out.println(p1.hashCode() == p2.hashCode()); // true
    }
}

class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
