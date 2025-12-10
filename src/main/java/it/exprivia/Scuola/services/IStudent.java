package it.exprivia.Scuola.services;

import java.util.List;

import it.exprivia.Scuola.models.dto.StudentDTO;

public interface IStudent {
	
		public List<StudentDTO> getStudents();
	
		public StudentDTO getStudent(Integer id);	
		
		public StudentDTO saveStudent(StudentDTO studDTO);
		
		public boolean deleteStudent(Integer id);
		
		// update student al momento senza senso perchè è servirebbe qualora inseriamo indirizzi

		// in input si 
		public StudentDTO updateStudent(Integer id, StudentDTO newStudent);

		// 

		public boolean login(String username, String password);

}
