package com.manageclass.ManageClass.Annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Constraint(validatedBy = EmailUfvValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUfv  {

    String message() default "Not Email UFV";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default{};
}

