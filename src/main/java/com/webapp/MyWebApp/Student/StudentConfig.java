package com.webapp.MyWebApp.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student student1 = new Student(
                    "student1",
                    "student1@test.com",
                    LocalDate.of(2000,2,24)
            );
            Student student2 = new Student(
                    "student2",
                    "student2@test.com",
                    LocalDate.of(1999,2,24)
            );
            Student student3 = new Student(
                    "student3",
                    "student3@test.com",
                    LocalDate.of(1999,2,24)
            );
            studentRepository.saveAll(
                    List.of(student1,student2,student3));
        };
    }
}
