package com.zw.munashe.studentcrudoperations.controller;

import com.zw.munashe.studentcrudoperations.entity.Student;
import com.zw.munashe.studentcrudoperations.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository repository;

    //get all the students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
       List<Student> students= repository.findAll();
        return students;
    }
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id){
       Student student= repository.findById(id).get();
        return student;

    }
    //create student
    @PostMapping("students/add")
    @ResponseStatus(code = HttpStatus.CREATED )
    public void createStudent(@RequestBody Student student){
        repository.save(student);

    }
    @PutMapping("/students/update/{id}")
    public Student updateStudent(@PathVariable int id){
        Student student = repository.findById(id).get();
        student.setName("james");
        student.setPercentage(98);
        student.setBranch("GEO");
        repository.save(student);
        return student;
    }
    @DeleteMapping("students/delete/{id}")
    @ResponseStatus(code=HttpStatus.GONE)
    public void deleteStudent(@PathVariable int id){
       Student student= repository.findById(id).get();
        repository.delete(student);
    }
}
