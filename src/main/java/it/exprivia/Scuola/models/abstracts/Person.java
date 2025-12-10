package it.exprivia.Scuola.models.abstracts;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
	// mettendo protected i figli che ereditano vedono gli attributi e non sono
	// visibili solo a questa
	// classe
	protected String username;
	protected String password;
	protected String firstName;
	protected String lastName;

	// consturctors

	public Person() {

	}

	public Person(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// getters and setters

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// to string

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + "]";
	}

}
