package it.exprivia.Scuola.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.exprivia.Scuola.models.Student;
import it.exprivia.Scuola.services.StudentServiceImpl;

@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private StudentServiceImpl service;

    @GetMapping("")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = service.getStudents();
        if (students.isEmpty() || students == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(students);

    }

    @GetMapping("{varId}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer varId) {
        Student student = service.getStudent(varId);
        if (varId != null && varId >= 1) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("{varId}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Integer id) {
        boolean deleted = service.deleteStudent(id);
        if (deleted) {
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("")
    public ResponseEntity<Student> createStudent(@RequestBody Student stud) {
        Student savedStudent = service.saveStudent(stud);
        if (stud != null && savedStudent.getId() > 0) {
            URI localUri = URI.create("api/students/" + savedStudent.getId());
            return ResponseEntity.created(localUri).body(savedStudent);
            // best practirce crersi l'uri per i nuovi studenti
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student newStudent) {
        Student modifiedStudent = service.updateStudent(id, newStudent);
        if (modifiedStudent != null) {
            return ResponseEntity.ok().body(modifiedStudent);

        }
        return ResponseEntity.notFound().build();
    }
}