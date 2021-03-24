package com.manageclass.ManageClass.Subjects;

import com.manageclass.ManageClass.Student.StudentResponse;
import com.manageclass.ManageClass.Teacher.TeacherResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectsResponseAll extends  SubjectsResponse{

    private List<StudentResponse> studentResponseList;

    public SubjectsResponseAll(Subjects subjects){
        super(subjects);
        this.studentResponseList = subjects.getStudent().stream().map(StudentResponse::new).collect(Collectors.toList());
    }
}
