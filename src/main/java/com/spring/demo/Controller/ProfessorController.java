package com.spring.demo.Controller;

import com.spring.demo.Model.Professor;
import com.spring.demo.Services.ProfessorServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorServiceImpl service;

    ProfessorController(ProfessorServiceImpl professorService) {
        service = professorService;
    }

    @GetMapping
    public List<Professor> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Professor findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/newProfessor")
    public Professor createProfessor(@RequestBody Professor professor) {
        return service.createProfessor(professor);
    }

    @PutMapping("/updateProfessor/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professor){
        return service.updateProfessor(id,professor);
    }

    @DeleteMapping("/deleteProfessor/{id}")
    public int deleteProfessorById(@PathVariable Long id){
        return service.deleteProfessorById(id);
    }
}
