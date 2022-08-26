package com.webapp.MyWebApp.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {
//    @Query("Select s form Student s where s.email=?1")
    Optional<Student> findStudentByEmail(String email);
}
