package com.manageclass.ManageClass.Subjects;

import com.manageclass.ManageClass.Student.Student;
import com.manageclass.ManageClass.Teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SubjectsRequest {

    @NotNull
    private Long cod;

    @NotEmpty
    private String name;

    private Teacher teacher;

    private List<Student> student;

    public Subjects toModel(){

        Subjects subjects = new Subjects();

        subjects.setCod(this.getCod());
        subjects.setName(this.getName());
        subjects.setTeacher(this.getTeacher());
        subjects.setStudent(this.getStudent());

        return subjects;
    }

}




