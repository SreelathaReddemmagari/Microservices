package com.Microservices.StudentService.controller;

import com.Microservices.StudentService.entity.Student;
import com.Microservices.StudentService.service.StudentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
    @GetMapping("/{id}")
    @CircuitBreaker(name="studentservice",fallbackMethod = "fallbackMethod")
    @ResponseStatus(HttpStatus.CREATED)
    public String getStudentWithDepartment(@PathVariable Long id){
        return studentService.getStudentWithDepartment(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    public  String fallbackMethod(@PathVariable Long id,RuntimeException ex){
        return "service is down ,please try after sometime";

    }


}
