package it.exprivia.progetto.models.abstracts;

/**
 * Base abstract person class used by model objects.
 */
public abstract class Person {
    // mettendo protected i figli che ereditano vedono gli attributi e non sono visibili solo a questa
    // classe

    protected String firstName;
    protected String lastName;

    public Person() {

    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
