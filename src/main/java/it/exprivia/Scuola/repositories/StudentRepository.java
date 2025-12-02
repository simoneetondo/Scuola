package it.exprivia.progetto.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import it.exprivia.progetto.models.Student;

@Repository
public class StudentRepository implements IRepositoryRead<Student>, IRepositoryWrite<Student> {

    // in questo modo se vogliamo creare qualche metodo ad esempio quello della
    // matricola dello studente lo possiamo fare
    // nello specifico qua dentro

    @Override
    public boolean Insert(Student obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Insert'");
    }

    @Override
    public boolean Update(Student obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public boolean Delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }

    @Override
    public Student getById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<Student> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
