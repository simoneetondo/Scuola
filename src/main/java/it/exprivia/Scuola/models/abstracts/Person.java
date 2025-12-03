package it.exprivia.Scuola.models.abstracts;

import jakarta.persistence.Entity;

@Entity
public abstract class Person {
	// mettendo protected i figli che ereditano vedono gli attributi e non sono
	// visibili solo a questa
	// classe
	protected Integer id;
	protected String firstName;
	protected String lastName;

	// consturctors
	
	public Person() {

	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// getters and setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	 
	// to string
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	
	
}
