package it.exprivia.Scuola.models.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO = DATA TRANSFER OBJECT non vogliamo toccare il db 
// si usano per fare operazioni/controlli/modifiche senza toccare le entità
// con le entità si interfaccia solamente il repository

// provando ad utilizzare lombock 

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {

    // valgono solo per le entità non per i dto
    // @Id
    // @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String stuNum;
    // metodo per formattare la data levando orario
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateBr;

}
