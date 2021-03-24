package com.manageclass.ManageClass.Subjects;

import com.manageclass.ManageClass.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Subjects")
public class SubjectsController {

    private SubjectsRepository repository;

    @Autowired
    public SubjectsController(SubjectsRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubjectsResponse createSubejects(@Valid @RequestBody SubjectsRequest subjectsRequest){

        Subjects subjects = this.repository.save(subjectsRequest.toModel());
        return new SubjectsResponse(subjects);

    }
}
