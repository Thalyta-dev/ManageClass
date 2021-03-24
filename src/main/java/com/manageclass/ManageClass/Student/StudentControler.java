package com.manageclass.ManageClass.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
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



}
