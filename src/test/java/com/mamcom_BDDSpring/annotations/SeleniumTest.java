package com.mamcom_BDDSpring.annotations;

//import org.springframework.boot.SpringApplicationExtensionsKt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
//@ExtendWith(SpringApplicationExtensionsKt.class)

public @interface SeleniumTest {
}
