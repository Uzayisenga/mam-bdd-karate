package mamcom_BDDSpring.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.lang.annotation.*;

@Lazy
@Bean
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BeanScope {
}
