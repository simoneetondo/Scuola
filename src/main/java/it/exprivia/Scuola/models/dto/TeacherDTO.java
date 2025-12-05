package it.exprivia.Scuola.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO = DATA TRANSFER OBJECT non vogliamo toccare il db 
// si usano per fare operazioni/controlli/modifiche senza toccare le entità
// con le entità si interfaccia solamente il repository

// DTO quasi uguale/identico alle entità, tranne in alcuni casi

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherDTO {

    // valgono solo per le entità non per i dto
    // a questo punto non penso abbia senso mantenere l'id
    // @Id
    // @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String teacherSub;

}
