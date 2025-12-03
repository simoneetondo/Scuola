package it.exprivia.Scuola.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.exprivia.Scuola.models.Student;
import it.exprivia.Scuola.repositories.IPersonRepository;

@Service
public class StudentServiceImpl implements IStudent {

	@Autowired
	private IPersonRepository<Student> repo;

	@Override
	public List<Student> getStudents() {
		return repo.findAll();
	}

	@Override
	public Student getStudent(Integer id) {
		if (id != null && id >= 1) {
			return repo.findById(id).orElse(null);
		}
		return null;
	}

	@Override
	public Student saveStudent(Student stud) {
		return repo.save(stud);
	}

	@Override
	public boolean deleteStudent(Integer id) {
		if (id == null || id <= 0) {
			return false;
		}
		if (!repo.existsById(id)) {
			return false;
		}
		repo.deleteById(id);
		return true;

	}

	@Override
	public Student updateStudent(Integer id, Student newStudent) {
		Optional<Student> student = repo.findById(id);

		if (student.isPresent()) {
			Student updatedStudent = student.get();
			updatedStudent.setFirstName(newStudent.getFirstName());
			updatedStudent.setLastName(newStudent.getLastName());
			updatedStudent.setStuNum(newStudent.getStuNum());
			updatedStudent.setDateBr(newStudent.getDateBr());
			repo.save(updatedStudent);
			return updatedStudent;
		}
		return null;
	}

}
