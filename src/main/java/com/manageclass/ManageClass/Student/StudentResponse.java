package com.manageclass.ManageClass.Student;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentResponse {

    private Long matricula;

    private String firstName;

    private String lastName;

    public StudentResponse(Student student){

        this.matricula = student.getMatricula();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();

    }


}
