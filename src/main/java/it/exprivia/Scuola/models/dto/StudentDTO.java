package it.exprivia.Scuola.models.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO = DATA TRANSFER OBJECT non vogliamo toccare il db 
// si usano per fare operazioni/controlli/modifiche senza toccare le entità
// con le entità si interfaccia solamente il repository

// provando ad utilizzare lombock 

// 

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDTO {

    // valgono solo per le entità non per i dto
    // @Id
    // @GeneratedValue
    //  Integer id;
    @JsonIgnore
    private String username;
    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;
    private String stuNum;
    // metodo per formattare la data levando orario
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateBr;

}
