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

import it.exprivia.Scuola.models.entity.Teacher;
import it.exprivia.Scuola.services.impl.TeacherServiceImpl;

@RestController
@RequestMapping("api/teachers")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl service;

    @GetMapping("")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = service.getAllTeachers();
        if (teachers == null || teachers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{varId}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Integer varId) {
        Teacher teach = service.getTeacher(varId);
        // serve effettivamente id>=1??
        if (varId != null || varId >= 1) {
            return ResponseEntity.ok(teach);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teach) {
        Teacher savedTeach = service.saveTeacher(teach);
        if (teach != null) {
            URI localUri = URI.create("api/students/" + savedTeach.getId());
            return ResponseEntity.created(localUri).body(savedTeach);
            // best practirce crersi l'uri per i nuovi studenti
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Integer id, @RequestBody Teacher teach) {
        Teacher newTeach = service.updateTeacher(id, teach);
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
