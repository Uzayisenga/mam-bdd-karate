package mamcom_BDDSpring.annotations;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Lazy
@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PageObjects {
}
