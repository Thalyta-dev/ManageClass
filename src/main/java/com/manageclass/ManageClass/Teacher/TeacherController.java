package com.manageclass.ManageClass.Teacher;

import com.manageclass.ManageClass.Exception.ExceptionNoFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/{matriculaTeacher}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherResponse findTeacher(@PathVariable Long matriculaTeacher) throws ExceptionNoFound {
        Teacher teacher = this.repository.findById(matriculaTeacher).orElseThrow(() -> new ExceptionNoFound(matriculaTeacher, "Teacher"));
        return new TeacherResponse(teacher);
    }
    @GetMapping
    public List<TeacherResponse> findAllTeacher(){
        return this.repository.findAll().stream().map(TeacherResponse::new).collect(Collectors.toList());
    }
}
