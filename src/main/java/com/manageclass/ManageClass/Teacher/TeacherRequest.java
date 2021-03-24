package com.manageclass.ManageClass.Teacher;

import com.manageclass.ManageClass.Annotation.EmailUfv;
import com.manageclass.ManageClass.Annotation.ExistCpf;
import com.manageclass.ManageClass.Subjects.Subjects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TeacherRequest {

    private Long matricula;

    @NotNull
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    @CPF
    @ExistCpf
    private String cpf;

    @Email
    @NotNull
    @EmailUfv
    private String email;

    public  Teacher  toModel(){

        Teacher teacher = new Teacher();
        teacher.setMatricula(this.getMatricula());
        teacher.setFirstName(this.getFirstName());
        teacher.setLastName(this.getLastName());
        teacher.setEmail(this.getEmail());
        teacher.setCpf(this.getCpf());

        return teacher;
    }
}

