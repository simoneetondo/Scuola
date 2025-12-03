package it.exprivia.Scuola.repositories;

import org.springframework.stereotype.Repository;

import it.exprivia.Scuola.models.Student;

@Repository
public interface StudentRepository extends IPersonRepository<Student> {

}
