package com.manageclass.ManageClass.Teacher;


import com.manageclass.ManageClass.Subjects.Subjects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teacher{
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

    @OneToMany( fetch = FetchType.EAGER, mappedBy = "teacher")// estou falando que esse é o lado fraco da relação
    List<Subjects> subjectsList;
}
