package com.spring.demo.Repository;

import com.spring.demo.Model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {
    List<Students> findByFirstName(String firstName);
}
