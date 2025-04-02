package kz.aboba.studentservice.controller;

import kz.aboba.studentservice.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    private static List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Aboba", "Computer Science", true),
            new Student(2, "Obabo", "Computer Science", false),
            new Student(3, "Ababa", "Management and administration", true)
    ));

    @GetMapping("")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Student student = students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping("/new-student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
            student.setId(students.size() + 1);
            System.out.println(student.toString());
            students.add(student);
            return ResponseEntity.ok(student);
        }
        catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/by-aboba/{isAbobing}")
    public ResponseEntity<List<Student>> getStudentByAbobing(@PathVariable boolean isAbobing) {
        List<Student> AbobaStudents = students.stream().filter(student -> student.isAbobing() == isAbobing).toList();

        if(AbobaStudents.size() > 0)
            return ResponseEntity.ok(AbobaStudents);
        return ResponseEntity.noContent().build();
    }
}
