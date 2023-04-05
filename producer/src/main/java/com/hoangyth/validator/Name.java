package com.hoangyth.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameValidator.class)
public @interface Name {

    String message() default " invalid user name";

    int min() default 0;

    int max() default 100;

    //represents group of constraints
     Class<?>[] groups() default {};
    //represents additional information about annotation
     Class<? extends Payload>[] payload() default {};


}