import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface AnotherAnnotation {

    String value() default "kim";  // value라고 쓰면 명시 안해도 됨

    int number() default 100;
}
