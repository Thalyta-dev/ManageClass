package com.manageclass.ManageClass.Annotation;

import com.manageclass.ManageClass.Student.Student;
import com.manageclass.ManageClass.Student.StudentRepository;
import com.manageclass.ManageClass.Teacher.Teacher;
import com.manageclass.ManageClass.Teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ExistCpfValidator implements ConstraintValidator<ExistCpf,String> {
    @Override
    public void initialize(ExistCpf constraintAnnotation) {

    }

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {

        Optional<Student> student = studentRepository.findByCpf(cpf);
        Optional<Teacher> teacher = teacherRepository.findByCpf(cpf);

        return (student.isEmpty() && teacher.isEmpty());
    }
}
