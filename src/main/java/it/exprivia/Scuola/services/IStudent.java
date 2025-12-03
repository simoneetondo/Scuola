package it.exprivia.Scuola.services;

import java.util.List;

import it.exprivia.Scuola.models.*;

public interface IStudent {
	
		public List<Student> getStudents();
	
		public Student getStudent(Integer id);	
		
		public Student saveStudent(Student stud);
		
		public boolean deleteStudent(Integer id);
		
		// update student al momento senza senso perchè è servirebbe qualora inseriamo indirizzi
		public Student updateStudent(Integer id, Student newStudent);

}
