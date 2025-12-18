package it.exprivia.Scuola.controller;

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

import it.exprivia.Scuola.models.dto.TeacherDTO;
import it.exprivia.Scuola.services.impl.TeacherServiceImpl;

@RestController
@RequestMapping("api/teachers")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl service;

    @GetMapping("")
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        List<TeacherDTO> teachers = service.getAllTeachers();
        if (teachers == null || teachers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{varId}")
    public ResponseEntity<TeacherDTO> getTeacher(@PathVariable Integer varId) {
        TeacherDTO teachDto = service.getTeacher(varId);
        // serve effettivamente id>=1?? || varId >= 1)

        if (varId != null) {
            return ResponseEntity.ok(teachDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO teachDTO) {
        TeacherDTO savedTeachDto = service.saveTeacher(teachDTO);
        if (savedTeachDto != null) {
           // URI localUri = URI.create("api/students/" + savedTeachDto.getId());
           // return ResponseEntity.created(localUri).body(savedTeachDto);
           return ResponseEntity.ok(savedTeachDto);
            // best practirce crersi l'uri per i nuovi studenti
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable Integer id, @RequestBody TeacherDTO teach) {
        TeacherDTO newTeach = service.updateTeacher(id, teach);
        if (newTeach != null) {
            return ResponseEntity.ok().body(newTeach);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTeacher(@PathVariable Integer id) {
        boolean deleted = service.deleteTeacher(id);
        if (deleted) {
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.badRequest().build();

    }

}
