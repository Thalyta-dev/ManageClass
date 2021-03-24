package com.manageclass.ManageClass.Subjects;

import com.manageclass.ManageClass.Exception.ExceptionNoFound;
import com.manageclass.ManageClass.Student.Student;
import com.manageclass.ManageClass.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/Subjects")
public class SubjectsController {

    private final SubjectsRepository subjectsRepository;
    private final StudentRepository studentRepository;

    public SubjectsController(SubjectsRepository subjectsRepository, StudentRepository studentRepository) {
        this.subjectsRepository = subjectsRepository;
        this.studentRepository = studentRepository;
    }




    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubjectsResponse createSubejects(@Valid @RequestBody SubjectsRequest subjectsRequest){

        Subjects subjects = this.subjectsRepository.save(subjectsRequest.toModel());
        return new SubjectsResponse(subjects);

    }

    @GetMapping("/{cod}")
    @ResponseStatus(HttpStatus.OK)
    public SubjectsResponse findSubjects(@PathVariable Long cod) throws ExceptionNoFound {
        Subjects subjects = this.subjectsRepository.findById(cod).orElseThrow(() -> new ExceptionNoFound(cod,"Subjects"));
        return new SubjectsResponse(subjects);

    }

    @Transactional
    @PutMapping("/addStudents/{cod}/{matricula}")
    public SubjectsResponse addSubjects(@PathVariable Long cod, @PathVariable Long matricula) throws ExceptionNoFound {

        Subjects subjects =subjectsRepository.findById(cod).orElseThrow(() -> new ExceptionNoFound(cod, "Subjects"));
        Student student = studentRepository.findById(matricula).orElseThrow(() -> new ExceptionNoFound(matricula, "Students"));
        System.out.println(student.getFirstName());
        subjects.getStudent().add(student);

        return new SubjectsResponseAll(subjects);

    }
}
