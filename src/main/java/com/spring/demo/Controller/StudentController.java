package com.spring.demo.Controller;

import com.spring.demo.Model.Students;
import com.spring.demo.Services.StudentServiceImpl;
import org.springframework.http.HttpStatus;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/newStudent")
    public Students createStudent(@Valid @RequestBody Students students) {
        return service.createStudent(students);
    }
    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/{pageNumber},{pageSize}")
    public List<Students> findAllPageable(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
        return service.findAllPageable(pageNumber, pageSize);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping
    public List<Students> findAll() {
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update/{id}")
    public Students updateStudent(@PathVariable Long id, @RequestBody Students students) {
        return service.updateStudentInformation(id,students);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public int deleteStudent(@PathVariable Long id) {
        return service.deleteStudent(id);
    }

}
