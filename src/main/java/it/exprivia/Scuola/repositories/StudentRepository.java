package it.exprivia.Scuola.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import it.exprivia.Scuola.models.entity.Student;

@Repository
public interface StudentRepository extends IPersonRepository<Student> {
	
	Optional<Student> findByStuNum(String stuNum);

}
