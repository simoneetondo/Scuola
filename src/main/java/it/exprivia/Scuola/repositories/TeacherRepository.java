package it.exprivia.progetto.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import it.exprivia.progetto.models.Teacher;

@Repository
public class TeacherRepository implements IRepositoryRead<Teacher> {

    @Override
    public Teacher getById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<Teacher> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
