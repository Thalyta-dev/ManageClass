package com.manageclass.ManageClass.Teacher;

import com.manageclass.ManageClass.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByCpf(String cpf);

}
