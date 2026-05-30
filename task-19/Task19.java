public class Task19 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        for (Planet planet : Planet.values()) {
            System.out.println(planet.getName() + ": " + planet.getOrderFromSun());
        }

        Operation operation = Operation.PLUS;
        System.out.println(operation.apply(5, 3));

        Operation secondOperation = Operation.MULTIPLY;
        System.out.println(secondOperation.apply(5, 3));
    }
}

// Практика #1: пример перечисления с инициализацией элементов.
enum Planet {
    MERCURY("Меркурий", 1),
    VENUS("Венера", 2),
    EARTH("Земля", 3),
    MARS("Марс", 4);

    private final String name;
    private final int orderFromSun;

    Planet(String name, int orderFromSun) {
        this.name = name;
        this.orderFromSun = orderFromSun;
    }

    public String getName() {
        return name;
    }

    public int getOrderFromSun() {
        return orderFromSun;
    }
}

// Практика #2: собственное перечисление с дополнительным методом.
enum Operation {
    PLUS {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },
    MINUS {
        @Override
        public int apply(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    };

    public abstract int apply(int a, int b);
}
