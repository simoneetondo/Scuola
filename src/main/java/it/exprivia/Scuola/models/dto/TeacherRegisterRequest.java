package it.exprivia.Scuola.models.dto;

public record TeacherRegisterRequest(
        String username,
        String password,
        String firstName,
        String lastName,
        String teacherSub) {

}
