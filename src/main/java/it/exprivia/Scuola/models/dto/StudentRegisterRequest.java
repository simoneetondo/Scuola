package it.exprivia.Scuola.models.dto;

import java.time.LocalDate;

public record StudentRegisterRequest (
    String username,
    String password,
    String firstName,
    String lastName,
    String stuNum,
    LocalDate dateBr

) {}
