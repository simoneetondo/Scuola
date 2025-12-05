package it.exprivia.Scuola.services;

import java.util.List;

import it.exprivia.Scuola.models.dto.TeacherDTO;

public interface ITeacher {

    public List<TeacherDTO> getAllTeachers();

    public TeacherDTO getTeacher(Integer id);

    public boolean deleteTeacher(Integer id);

    public TeacherDTO saveTeacher(TeacherDTO teachDTO);

    // qualora dovessimo modificare la materia dell'insegnante
    
    public TeacherDTO updateTeacher(Integer id, TeacherDTO teach);
}
