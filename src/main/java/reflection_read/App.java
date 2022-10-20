package reflection_read;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        Class<Book> bookClass = Book.class;  // class 를 가져오면 인스턴스가 heap에 저장된다.

        System.out.println("===============getFields===============");
        Field[] fields = bookClass.getFields();  // Field 배열이 나온다. 이 메서드는 public만 가져온다.
        Arrays.stream(fields).forEach(System.out::println);
        System.out.println();

        System.out.println("===============getDeclaredFields===============");
        Field[] declaredFields = bookClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(System.out::println);
        System.out.println();

        System.out.println("===============getDeclaredFields2===============");
        Book book = new Book();
        Arrays.stream(declaredFields).forEach(f -> {
            try {
                f.setAccessible(true);  // 리플렉션에서는 접근 지시자를 무시할 수 있다.
                System.out.printf("%s %s%n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        System.out.println();

        System.out.println("===============getDeclaredFields3===============");
        Arrays.stream(declaredFields).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println("IsPrivate? = " + Modifier.isPrivate(modifiers));
            System.out.println("IsStatic? = " + Modifier.isStatic(modifiers));
        });
        System.out.println();

        System.out.println("===============getDeclaredFields4===============");
        Arrays.stream(declaredFields).forEach(f -> {
            Arrays.stream(f.getAnnotations()).forEach(a -> {
                if (a instanceof AnotherAnnotation) {
                    AnotherAnnotation anotherAnnotation = (AnotherAnnotation) a;
                    System.out.println(anotherAnnotation.value());
                    System.out.println(anotherAnnotation.number());
                }
            });
        });
        System.out.println();

        System.out.println("===============getMethods===============");
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);
        System.out.println();

        System.out.println("===============getDeclaredConstructors===============");
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);
        System.out.println();

        System.out.println("===============getSuperClass===============");
        Class<? super MyBook> superclass = MyBook.class.getSuperclass();
        System.out.println(superclass);
        System.out.println();

        System.out.println("===============getInterfaces===============");
        Class<?>[] interfaces = MyBook.class.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);
        System.out.println();

        System.out.println("===============getAnnotations===============");
        Annotation[] annotations = Book.class.getAnnotations();
        Arrays.stream(annotations).forEach(System.out::println);
        System.out.println();

        System.out.println("===============getAnnotations===============");
        Annotation[] myBookAnnotation = MyBook.class.getAnnotations();
        Arrays.stream(myBookAnnotation).forEach(System.out::println);
        System.out.println();

        System.out.println("===============getDeclaredAnnotations===============");
        Annotation[] declaredAnnotations = MyBook.class.getDeclaredAnnotations();
        Arrays.stream(declaredAnnotations).forEach(System.out::println);
        System.out.println();


    }
}
