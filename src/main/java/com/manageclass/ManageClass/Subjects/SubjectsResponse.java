package com.manageclass.ManageClass.Subjects;

import com.manageclass.ManageClass.Teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectsResponse {

    private Long cod;

    private String name;

    private Teacher teacher;

    public SubjectsResponse(Subjects subjects){

        this.setCod(subjects.getCod());
        this.setName(subjects.getName());
        this.setTeacher(subjects.getTeacher());

    }

}
