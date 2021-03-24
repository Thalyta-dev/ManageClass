package com.manageclass.ManageClass.Teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TeacherResponse {

    private  Long matricula;

    private  String firstName;

    private String lastName;

    public TeacherResponse(Teacher teacher){

        this.matricula = teacher.getMatricula();
        this.firstName = teacher.getFirstName();
        this.lastName = teacher.getLastName();

    }
}


