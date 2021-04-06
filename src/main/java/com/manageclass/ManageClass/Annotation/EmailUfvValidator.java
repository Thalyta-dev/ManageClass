package com.manageclass.ManageClass.Annotation;

import com.manageclass.ManageClass.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUfvValidator implements ConstraintValidator<EmailUfv,String> {

    @Override
    public void initialize(EmailUfv constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        return email.substring(email.indexOf("@")+1).equals("ufv.br");
    }
}
