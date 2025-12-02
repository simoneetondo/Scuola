package it.exprivia.progetto.models;

import java.sql.Date;

import it.exprivia.progetto.models.abstracts.Person;

public class Student extends Person {

    private String stuNum;
    private Date dateBr;

    // costruttore vuoto 
	public Student() {
		super();
	}

    // costruttore con param
	public Student(String firstName, String lastName) {
		super(firstName, lastName);
        this.stuNum = stuNum;
        this.dateBr = dateBr;
	}

    // getters and setters

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public Date getDateBr() {
        return dateBr;
    }

    public void setDateBr(Date dateBr) {
        this.dateBr = dateBr;
    }

    // to string che include gli attributi della superclase e fa sempre comodo

    @Override
    public String toString() {
        return "Student [stuNum=" + stuNum + ", dateBr=" + dateBr + ", firstName=" + firstName + ", lastName="
                + lastName + "]";
    }

    
}
