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

import it.exprivia.Scuola.models.dto.StudentDTO;
import it.exprivia.Scuola.models.entity.Student;
import it.exprivia.Scuola.services.impl.StudentServiceImpl;

@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private StudentServiceImpl service;

    // inserire un oggetto di tipo DTO e mapparlo nel service

    @GetMapping("")
    public ResponseEntity<List<StudentDTO>> getStudents() {
        List<StudentDTO> students = service.getStudents();
        if (students.isEmpty() || students == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(students);

    }

    @GetMapping("{varId}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Integer varId) {
        StudentDTO student = service.getStudent(varId);
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
        public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO stud) {
            StudentDTO savedStudent = service.saveStudent(stud);
            if (savedStudent != null) {
                URI localUri = URI.create("api/students/" + savedStudent.getId());
                return ResponseEntity.created(localUri).body(savedStudent);
                // best practirce crersi l'uri per i nuovi studenti
            }
            return ResponseEntity.badRequest().build();
        }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Integer id, @RequestBody StudentDTO newStudent) {
        StudentDTO modifiedStudent = service.updateStudent(id, newStudent);
        if (modifiedStudent != null) {
            return ResponseEntity.ok().body(modifiedStudent);

        }
        return ResponseEntity.notFound().build();
    }
}