package it.exprivia.Scuola.models.dto;

// DTO = DATA TRANSFER OBJECT non vogliamo toccare il db 
// si usano per fare operazioni/controlli/modifiche senza toccare le entità
// con le entità si interfaccia solamente il repository

// DTO quasi uguale/identico alle entità, tranne in alcuni casi

// @EqualsAndHashCode
// @NoArgsConstructor
// @AllArgsConstructor
// @Getter
// @Setter
public record TeacherDTO(
    Integer id,
    String username,
    String firstName,
    String lastName,
    String teacherSub
) implements PersonDTO {}

    // valgono solo per le entità non per i dto
    // a questo punto non penso abbia senso mantenere l'id
    // @Id
    // @GeneratedValue
    // private Integer id;
    // @JsonIgnore
    // private String username;
    // @JsonIgnore
    // private String password;
    // private String firstName;
    // private String lastName;
    // private String teacherSub;


