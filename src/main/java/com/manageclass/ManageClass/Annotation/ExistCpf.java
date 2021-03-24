package com.manageclass.ManageClass.Annotation;

import javax.validation.Constraint;
import java.lang.annotation.*;
import javax.validation.Payload;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistCpfValidator.class)
@Target(ElementType.FIELD)

public @interface ExistCpf {

    String message() default "Exist Cpf";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
