package com.spring.demo.Services;

import com.spring.demo.Model.Students;
import com.spring.demo.Repository.StudentRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl {

    private final StudentRepository repository;

    // Constructor.
    // Dependency Injection.
    StudentServiceImpl(StudentRepository studentRepository) {
        repository = studentRepository;
    }

    public List<Students> findAllPageable(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        pageable.getSort().ascending();
        return repository.findAll(pageable).getContent();
    }

    public List<Students> findAll() {
        return repository.findAll();
    }
    public Students createStudent(Students students) {
        return repository.save(students);
    }

    public Students updateStudentInformation(Long id, Students students) {
        Optional<Students> optional = repository.findById(id);

        if(optional.isPresent()){
            students.setId(optional.get().getId());
            return repository.save(students);
        }else {
            throw new RuntimeException("Student Doesn't Exist!");
        }
    }

    public int deleteStudent(Long id) {
        Optional<Students> optional = repository.findById(id);
        int count = 0;
        if(optional.isPresent()) {
            count++;
            repository.deleteById(optional.get().getId());
            return count;
        }else {
            throw new RuntimeException("No Student to be Deleted! Check the ID");
        }
    }
}
