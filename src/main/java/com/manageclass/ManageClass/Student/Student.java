package com.manageclass.ManageClass.Student;

import com.manageclass.ManageClass.Subjects.Subjects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private Long matricula;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false,unique = true)
    private String cpf;

    @Column(nullable = false,unique = true)
    private String email;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    List<Subjects> subjects= new ArrayList<>();

}
