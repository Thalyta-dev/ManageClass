package com.manageclass.ManageClass.Subjects;

import com.manageclass.ManageClass.Exception.ExceptionNoFound;
import com.manageclass.ManageClass.Student.Student;
import com.manageclass.ManageClass.Student.StudentRepository;
import com.manageclass.ManageClass.Teacher.Teacher;
import com.manageclass.ManageClass.Teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Subjects")
public class SubjectsController {

    private final SubjectsRepository subjectsRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public SubjectsController(SubjectsRepository subjectsRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.subjectsRepository = subjectsRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository =  teacherRepository;
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
    @PutMapping("/addStudents/{cod}/{matriculaStudents}")
    public SubjectsResponse addStudentsInSubjects(@PathVariable Long cod, @PathVariable Long matriculaStudents) throws ExceptionNoFound {

        Subjects subjects =subjectsRepository.findById(cod).orElseThrow(() -> new ExceptionNoFound(cod, "Subjects"));
        Student student = studentRepository.findById(matriculaStudents).orElseThrow(() -> new ExceptionNoFound(matriculaStudents, "Students"));
        System.out.println(student.getFirstName());
        subjects.getStudent().add(student);

        return new SubjectsResponseAll(subjects);

    }

    @Transactional
    @PutMapping("/addTeacher/{cod}/{matriculaTeacher}")
    public SubjectsResponse addTeacherInSubjects(@PathVariable Long cod, @PathVariable Long matriculaTeacher) throws ExceptionNoFound {

        Subjects subjects =subjectsRepository.findById(cod).orElseThrow(() -> new ExceptionNoFound(cod, "Subjects"));
        Teacher teacher = teacherRepository.findById(matriculaTeacher).orElseThrow(() -> new ExceptionNoFound(matriculaTeacher, "Teacher"));
        System.out.println(teacher.getFirstName());
        subjects.setTeacher(teacher);

        return new SubjectsResponseAll(subjects);

    }

    @GetMapping
    public List<SubjectsResponse> getAllSubjects(){
        return  subjectsRepository.findAll().stream().map(SubjectsResponse::new).collect(Collectors.toList());
    }


}
