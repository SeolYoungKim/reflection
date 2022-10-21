package reflection_use;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> noteClass = Class.forName("reflection_use.Note");

        Constructor<?> noArgsConstructor = noteClass.getConstructor(null);
        Note note = (Note) noArgsConstructor.newInstance();
        System.out.println(note);

        Constructor<?> argsConstructor = noteClass.getConstructor(String.class);
        Note myNote = (Note) argsConstructor.newInstance("myNote");
        System.out.println(myNote);

        Field a = Note.class.getDeclaredField("A");
        System.out.println(a.get(null));  // static은 그냥 가져올 수 있다.

        a.set(null, "AAAAAAA");  // static의 값을 바꿀 때는 obj에 null을 넘겨준다.
        System.out.println(a.get(null));

        Field b = Note.class.getDeclaredField("b");
        b.setAccessible(true);
        System.out.println(b.get(note));  // 인스턴스 필드는 인스턴스를 넣어줘야 한다.

        b.set(note, "BBBBBBB");
        System.out.println(b.get(note));

        Method c = Note.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(note);

        Method sum = Note.class.getDeclaredMethod("sum", int.class, int.class);
        System.out.println(sum.invoke(note, 1, 2));

    }
}
