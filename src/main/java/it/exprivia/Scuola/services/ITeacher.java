package it.exprivia.Scuola.services;

import java.util.List;

import it.exprivia.Scuola.models.Teacher;

public interface ITeacher {

    public List<Teacher> getAllTeachers();

    public Teacher getTeacher(Integer id);

    public boolean deleteTeacher(Integer id);

    public Teacher saveTeacher(Teacher teach);

    // qualora dovessimo modificare la materia dell'insegnante
    
    public Teacher updateTeacher(Integer id, Teacher teach);
}
