package it.exprivia.Scuola.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.exprivia.Scuola.models.Teacher;
import it.exprivia.Scuola.repositories.IPersonRepository;

@Service
public class TeacherServiceImpl implements ITeacher {

    @Autowired
    private IPersonRepository<Teacher> repo;

    @Override
    public List<Teacher> getAllTeachers() {
        return repo.findAll();

    }

    @Override
    public Teacher getTeacher(Integer id) {
        if (id != 0 && id >= 1) {
            return repo.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public boolean deleteTeacher(Integer id) {
        if (id == 0 || id == null) {
            return false;
        }
        if (!repo.existsById(id)) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }

    @Override
    public Teacher saveTeacher(Teacher teach) {
        if (teach != null) {
            return repo.save(teach);
        }
        return null;
    }

    @Override
    public Teacher updateTeacher(Integer id, Teacher newTeach) {
        Optional<Teacher> teach = repo.findById(id);

        if (teach.isPresent()) {
            Teacher updatedTeacher = teach.get();
            updatedTeacher.setFirstName(newTeach.getFirstName());
            updatedTeacher.setLastName(newTeach.getLastName());
            updatedTeacher.setTeacherSub(newTeach.getTeacherSub());
            repo.save(updatedTeacher);
            return updatedTeacher;
        }
        return null;
    }

}
