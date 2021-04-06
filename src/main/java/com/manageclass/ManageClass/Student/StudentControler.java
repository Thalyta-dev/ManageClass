package com.manageclass.ManageClass.Student;

import com.manageclass.ManageClass.Exception.ExceptionNoFound;
import com.manageclass.ManageClass.Subjects.SubjectsResponse;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


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

    @GetMapping
    public List<StudentResponse> getAllSubjects(){
        return  repository.findAll().stream().map(StudentResponse::new).collect(Collectors.toList());
    }



}
