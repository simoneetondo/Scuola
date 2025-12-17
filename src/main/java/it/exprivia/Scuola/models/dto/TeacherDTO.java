package it.exprivia.Scuola.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO = DATA TRANSFER OBJECT non vogliamo toccare il db 
// si usano per fare operazioni/controlli/modifiche senza toccare le entità
// con le entità si interfaccia solamente il repository

// DTO quasi uguale/identico alle entità, tranne in alcuni casi

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherDTO {

    // valgono solo per le entità non per i dto
    // a questo punto non penso abbia senso mantenere l'id
    // @Id
    // @GeneratedValue
    // private Integer id;
    @JsonIgnore
    private String username;
    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;
    private String teacherSub;

}
