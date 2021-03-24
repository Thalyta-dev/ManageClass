package com.manageclass.ManageClass.Student;

import com.manageclass.ManageClass.Exception.ExceptionNoFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/Students")
public class StudentControler {

    private  StudentRepository repository;

    @Autowired
    public StudentControler(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse createPerson(@RequestBody @Valid StudentRequest studentRequest){

        Student saveStudent =  repository.save(studentRequest.toModel());
        return new StudentResponse(saveStudent);

    }

    @GetMapping("/{matricula}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse getStudent( @PathVariable Long matricula) throws ExceptionNoFound {

        Student  student = repository.findById(matricula).orElseThrow(()-> new ExceptionNoFound(matricula, "Student"));
        return new StudentResponse(student);
    }




}
