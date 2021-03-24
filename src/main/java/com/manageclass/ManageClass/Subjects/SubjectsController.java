package com.manageclass.ManageClass.Subjects;

import com.manageclass.ManageClass.Exception.ExceptionNoFound;
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

    @GetMapping("/{cod}")
    @ResponseStatus(HttpStatus.OK)
    public SubjectsResponse findSubjects(@PathVariable Long cod) throws ExceptionNoFound {
        Subjects subjects = this.repository.findById(cod).orElseThrow(() -> new ExceptionNoFound(cod,"Subjects"));
        return new SubjectsResponse(subjects);

    }
}
