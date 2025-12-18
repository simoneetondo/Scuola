package it.exprivia.Scuola.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import it.exprivia.Scuola.models.dto.StudentDTO;
import it.exprivia.Scuola.models.dto.StudentRegisterRequest;
import it.exprivia.Scuola.models.entity.Student;

// al momento non viene utilizzato per lo student
// mapstruct genererà un bean di spring per il mapper e puoi utilizzarlo per gestire i componenti

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(StudentRegisterRequest studentReg);
    Student toEntity(StudentDTO studentDTO);

    StudentDTO toDTO(Student student);

    List<StudentDTO> toDTOList(List<Student> students);

}