package com.spring.demo.Services;

import com.spring.demo.Model.Professor;
import com.spring.demo.Repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl {

    private final ProfessorRepository repository;

    ProfessorServiceImpl(ProfessorRepository professorRepository){
        repository = professorRepository;
    }

    public List<Professor> findAll() {
        return repository.findAll();
    }

    public Professor findById(Long id) {
        Optional<Professor> optional = repository.findById(id);

        if(optional.isPresent()) {
            return optional.get();
        }else {
            throw  new RuntimeException("No Professor Available!");
        }
    }

    public Professor createProfessor(Professor professor) {
        return  repository.save(professor);
    }

    public Professor updateProfessor(Long id, Professor professor) {

        Optional<Professor> optional = repository.findById(id);

        if(optional.isPresent()) {
            professor.setId(optional.get().getId());
            return repository.save(professor);
        }else {
            throw new RuntimeException("No Professor to be Updated");
        }
    }

    public int deleteProfessorById(Long id) {
        Optional<Professor> optional = repository.findById(id);
        int count = 0;
        if(optional.isPresent()) {
            count++;
            repository.deleteById(optional.get().getId());
            return count;
        }else {
            throw new RuntimeException("No Professor to be Deleted");
        }
    }
}
