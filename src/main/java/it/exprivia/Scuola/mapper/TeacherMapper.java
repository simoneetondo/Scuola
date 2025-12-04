package it.exprivia.Scuola.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import it.exprivia.Scuola.models.dto.TeacherDTO;
import it.exprivia.Scuola.models.entity.Teacher;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    Teacher toEntity(TeacherDTO teacherDTO);

    TeacherDTO toDTO(Teacher teacher);

    List<TeacherDTO> toDTOList(List<Teacher> teachersEnt);

    List<Teacher> toEntityList(List<TeacherDTO> teachersDTO);
    
}
