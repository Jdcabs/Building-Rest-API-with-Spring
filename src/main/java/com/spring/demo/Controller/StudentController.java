package com.spring.demo.Controller;

import com.spring.demo.Model.Students;
import com.spring.demo.Services.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentServiceImpl service;

    // Constructor.
    // Dependency Injection.
    StudentController(StudentServiceImpl studentService) {
        service = studentService;
    }

    @PostMapping("/newStudent")
    public Students createStudent(@Valid @RequestBody Students students) {
        return service.createStudent(students);
    }

    @GetMapping
    public List<Students> findALl() {
        return service.findAll();
    }

    @PutMapping("/update/{id}")
    public Students updateStudent(@PathVariable Long id, @RequestBody Students students) {
        return service.updateStudentInformation(id,students);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteStudent(@PathVariable Long id) {
        return service.deleteStudent(id);
    }

}
