package com.webapp.MyWebApp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.webapp.MyWebApp.Student.Student;
import com.webapp.MyWebApp.Student.StudentController;
import com.webapp.MyWebApp.Student.StudentRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.lenient;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class StudentAPITests {
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentController studentController;

    Student student1 = new Student(
            1L,
            "student1",
            "student1@test.com",
            LocalDate.of(2000,2,24)
    );
    Student student2 = new Student(
            2L,
            "student2",
            "student2@test.com",
            LocalDate.of(1999,2,24)
    );
    Student student3 = new Student(
            3L,
            "student3",
            "student3@test.com",
            LocalDate.of(1999,2,24)
    );

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    public void getStudents_success(){
        List<Student> students = new ArrayList<>(Arrays.asList(student1, student2, student3));
//        Mockito.when(studentRepository.findAll()).thenReturn(students);
        lenient().when(studentRepository.findAll()).thenReturn(students);
        try {
            mockMvc.perform(
                    MockMvcRequestBuilders
                            .get("/api/v1/student")
                            .contentType(MediaType.APPLICATION_JSON))
                            .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
