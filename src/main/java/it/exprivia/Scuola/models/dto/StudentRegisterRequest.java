package it.exprivia.Scuola.models.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record StudentRegisterRequest (

    @NotBlank(message= "Il campo è obbligatorio.")
    String username,

    @NotBlank(message= "Il campo è obbligatorio")
    @Size(min = 8, max = 18, message = "La password deve contentere almeno 8 caratteri.")
    @Pattern(
    regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$", 
    message = "La password deve contenere almeno una lettera maiuscola, una minuscola e un numero"
    )
    String password,

    @NotBlank(message= "Il campo è obbligatorio.")
    String firstName,
    
    @NotBlank(message= "Il campo è obbligatorio.")
    String lastName,

    @NotBlank(message= "Il campo è obbligatorio.")
    String stuNum,

    LocalDate dateBr

    // gestire eventuali problemi di validazione con i problem detail.
    

) {}
