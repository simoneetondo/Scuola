package it.exprivia.Scuola.models.dto;

import java.sql.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

    @Id
	//   @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String stuNum;
    private Date dateBr;



}
