import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Практика #1
 * Объяснение аннотаций @Override, @Deprecated, @SuppressWarnings
 * и примеры их использования.
 */
public class Task29 {
    // Настройка кодировки вывода для корректного отображения русского текста в консоли.
    static {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ChildAnnotationExample child = new ChildAnnotationExample();
        child.print();

        OldApi oldApi = new OldApi();
        oldApi.newMethod();
        useDeprecatedMethod();

        RawTypeExample.useRawList();

        Class<AnnotatedService> clazz = AnnotatedService.class;
        TaskInfo info = clazz.getAnnotation(TaskInfo.class);
        System.out.println("Аннотация TaskInfo: " + info.author() + ", level=" + info.level());
    }

    @SuppressWarnings("deprecation")
    private static void useDeprecatedMethod() {
        OldApi oldApi = new OldApi();
        oldApi.oldMethod();
    }
}

class ParentAnnotationExample {
    void print() {
        System.out.println("Parent method");
    }
}

class ChildAnnotationExample extends ParentAnnotationExample {
    /**
     * @Override показывает, что метод должен переопределять метод суперкласса.
     * Если ошибиться в имени или параметрах, компилятор сразу покажет ошибку.
     */
    @Override
    void print() {
        System.out.println("Child method with @Override");
    }
}

class OldApi {
    /**
     * @Deprecated показывает, что метод устарел и лучше использовать другой вариант.
     */
    @Deprecated
    void oldMethod() {
        System.out.println("Устаревший метод");
    }

    void newMethod() {
        System.out.println("Новый метод");
    }
}

class RawTypeExample {
    /**
     * @SuppressWarnings подавляет предупреждения компилятора.
     * Его не стоит использовать без причины: лучше исправлять проблему.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    static void useRawList() {
        java.util.List list = new java.util.ArrayList();
        list.add("text");
        System.out.println(list.get(0));
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TaskInfo {
    String author();
    int level();
}

@TaskInfo(author = "Student", level = 2)
class AnnotatedService {
}
