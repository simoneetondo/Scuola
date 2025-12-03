package it.exprivia.Scuola.models;

import it.exprivia.Scuola.models.abstracts.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Teacher extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String teacherSub;

	// costruttore vuoto

	public Teacher() {
		super();
	}

	// costruttore con param

	public Teacher(String firstName, String lastName) {
		super(firstName, lastName);
	}

	// getters and setters

	public Integer getId() {
		return this.id;
	}

	public String getTeacherSub() {
		return teacherSub;
	}

	public void setTeacherSub(String teacherSub) {
		this.teacherSub = teacherSub;
	}

	// to string che include gli attributi della superclase e fa sempre comodo

	@Override
	public String toString() {
		return "Teacher [teacherSub=" + teacherSub + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
