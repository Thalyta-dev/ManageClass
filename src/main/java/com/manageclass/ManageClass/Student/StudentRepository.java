package com.manageclass.ManageClass.Student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

     Optional<Student> findByCpf(String cpf);
}
