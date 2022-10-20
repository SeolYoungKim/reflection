import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface MyAnnotation {

    String value() default "kim";  // value라고 쓰면 명시 안해도 됨

    int number() default 100;
}
