package com.manageclass.ManageClass.Student;

import com.manageclass.ManageClass.Annotation.EmailUfv;
import com.manageclass.ManageClass.Annotation.ExistCpf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentRequest {

    @NotNull
    private Long matricula;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @CPF
    @ExistCpf
    private String cpf;

    @NotEmpty
    @Email
    @EmailUfv
    private String email;


    public Student toModel(){

        Student student = new Student();

        student.setMatricula(this.getMatricula());
        student.setFirstName(this.getFirstName());
        student.setLastName(this.getLastName());
        student.setCpf(this.getCpf());
        student.setEmail(this.getEmail());

        return student;

    }



}
