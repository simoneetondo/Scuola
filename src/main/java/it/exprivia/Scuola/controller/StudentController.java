package it.exprivia.Scuola.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import it.exprivia.Scuola.models.dto.StudentRegisterRequest;
import it.exprivia.Scuola.services.IStudent;
import it.exprivia.Scuola.services.impl.StudentServiceImpl;

@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private IStudent service;

    // inserire un oggetto di tipo DTO e mapparlo nel service

    // GET ALL
    @GetMapping("")
    public ResponseEntity<List<StudentDTO>> getStudents() {
        return ResponseEntity.ok(service.getStudents());

    }

    // GET BY ID
    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getStudent(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();

    }

    @PostMapping("")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentRegisterRequest stud) {
        StudentDTO createdStudent = service.saveStudent(stud);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
    
    // UPDATE 
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Integer id, @RequestBody StudentDTO newStudent) {
        StudentDTO modifiedStudent = service.updateStudent(id, newStudent);
        return new ResponseEntity<>(modifiedStudent, HttpStatus.OK);
    }
}