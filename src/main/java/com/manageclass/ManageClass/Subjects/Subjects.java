package com.manageclass.ManageClass.Subjects;

import com.manageclass.ManageClass.Student.Student;
import com.manageclass.ManageClass.Teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;

    private String name;


    @ManyToOne
    private Teacher teacher;

    @ManyToMany
    private List<Student>  student;

}
