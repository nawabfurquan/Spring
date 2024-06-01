package com.springdemo.rest;

import com.springdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

    @PostConstruct()
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Chad", "Darby"));
        students.add(new Student("Robert", "Downy Jr"));
        students.add(new Student("Lionel", "Messi"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentFromId(@PathVariable int studentId) {
        if ((studentId >= students.size() || studentId < 0) ) {
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }
        return this.students.get(studentId);
    }

}
