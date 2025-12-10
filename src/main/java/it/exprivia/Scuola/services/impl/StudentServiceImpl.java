package it.exprivia.Scuola.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.exprivia.Scuola.models.dto.StudentDTO;
import it.exprivia.Scuola.models.entity.Student;
import it.exprivia.Scuola.models.entity.Teacher;
import it.exprivia.Scuola.repositories.StudentRepository;
import it.exprivia.Scuola.services.IStudent;

@Service
public class StudentServiceImpl implements IStudent {

	@Autowired
	private StudentRepository repo;

	@Override
	public List<StudentDTO> getStudents() {
		return repo.findAll().stream()
				.map(student -> {
					StudentDTO dto = new StudentDTO();
					// dto.setId(student.getId());
					dto.setFirstName(student.getFirstName());
					dto.setLastName(student.getLastName());
					dto.setStuNum(student.getStuNum());
					dto.setDateBr(student.getDateBr());
					return dto;
				})
				.toList();
	}

	@Override
	public StudentDTO getStudent(Integer id) {
		Student stud = repo.findById(id).orElse(null);
		StudentDTO studDTO = new StudentDTO();
		// studDTO.setId(stud.getId());
		studDTO.setFirstName(stud.getFirstName());
		studDTO.setLastName(stud.getLastName());
		studDTO.setDateBr(stud.getDateBr());
		studDTO.setStuNum(stud.getStuNum());
		return studDTO;
	}

	@Override
	public StudentDTO saveStudent(StudentDTO studDTO) {

		// al momento unica verifica sensata tramite il numero che deve essere univoco
		// non chiedendo l'id
		Optional<Student> existing = repo.findByStuNum(studDTO.getStuNum());
		if (existing.isPresent()) {
			return null;
		}

		Student student = new Student();

		student.setUsername(studDTO.getUsername());
		student.setPassword(studDTO.getPassword());
		student.setFirstName(studDTO.getFirstName());
		student.setLastName(studDTO.getLastName());
		student.setDateBr(studDTO.getDateBr());
		student.setStuNum(studDTO.getStuNum());

		repo.save(student);

		// perchè non mi prende dal dto l'id autogenerato?
		// studDTO.setId(student.getId());
		return studDTO;
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
	public StudentDTO updateStudent(Integer id, StudentDTO newStudent) {
		Optional<Student> student = repo.findById(id);

		if (student.isPresent()) {
			Student updatedStudent = student.get();
			updatedStudent.setFirstName(newStudent.getFirstName());
			updatedStudent.setLastName(newStudent.getLastName());
			updatedStudent.setStuNum(newStudent.getStuNum());
			updatedStudent.setDateBr(newStudent.getDateBr());
			repo.save(updatedStudent);
			StudentDTO studDTO = new StudentDTO();
			// studDTO.setId(updatedStudent.getId());
			studDTO.setFirstName(updatedStudent.getFirstName());
			studDTO.setLastName(updatedStudent.getLastName());
			studDTO.setStuNum(updatedStudent.getStuNum());
			studDTO.setDateBr(updatedStudent.getDateBr());
			return studDTO;
		}
		return null;
	}

	public boolean login(String username, String password) {

		Optional<Student> stud = repo.findByUsernameAndPassword(username, password);

		if (stud.isEmpty())
			return false;
		if (!stud.get().getPassword().equals(password) && !stud.get().getUsername().equals(username))
			return false;

		return true;

	}
}
