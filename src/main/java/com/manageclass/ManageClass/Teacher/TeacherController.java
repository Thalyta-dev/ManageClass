package com.manageclass.ManageClass.Teacher;

import com.manageclass.ManageClass.Exception.ExceptionNoFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Teacher")
public class TeacherController {


    private TeacherRepository repository;

    @Autowired
    public TeacherController(TeacherRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherResponse createTeacher(@Valid @RequestBody TeacherRequest teacherRequest){

        Teacher saveTeacher= repository.save(teacherRequest.toModel());
        return new TeacherResponse(saveTeacher);
    }

    @GetMapping("/{matricula}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherResponse findTeacher(@PathVariable Long matricula) throws ExceptionNoFound {
        Teacher teacher = this.repository.findById(matricula).orElseThrow(() -> new ExceptionNoFound(matricula, "Teacher"));
        return new TeacherResponse(teacher);
    }

}
