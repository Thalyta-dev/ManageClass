package com.manageclass.ManageClass.Student;


import com.manageclass.ManageClass.Subjects.Subjects;
import com.manageclass.ManageClass.Subjects.SubjectsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentResponse {

    private Long matricula;

    private String firstName;

    private String lastName;

    private List<SubjectsResponse> subjectsResponses;
    public StudentResponse(Student student){

        this.matricula = student.getMatricula();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.subjectsResponses = student.getSubjects().stream().map(SubjectsResponse::new).collect(Collectors.toList());

    }


}
