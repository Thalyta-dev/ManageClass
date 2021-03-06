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

    public SubjectsResponse(Subjects subjects){

        this.cod = subjects.getCod();
        this.name = subjects.getName();

    }

}
