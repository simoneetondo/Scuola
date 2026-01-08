package it.exprivia.Scuola.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.exprivia.Scuola.exception.ResourceNotFoundException;
import it.exprivia.Scuola.mapper.TeacherMapper;
import it.exprivia.Scuola.models.dto.TeacherDTO;
import it.exprivia.Scuola.models.entity.Teacher;
import it.exprivia.Scuola.repositories.TeacherRepository;
import it.exprivia.Scuola.services.ITeacher;
import jakarta.annotation.Resource;

@Service
public class TeacherServiceImpl implements ITeacher {

    @Autowired
    private TeacherRepository repo;

    // inject del mapper
    @Autowired
    private TeacherMapper mapper;

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return mapper.toDTOList(repo.findAll());

        // puoi mappare direttamente la lista dal mapstruct e convertire tutte le entità
        // che hai nel repository in una lista dtos

        // List<TeacherDTO> dtos = mapper.toDTOList(repo.findAll());
        // return dtos;
    }

    @Override
    public TeacherDTO getTeacher(Integer id) {
        // non serve il controllo se abbiamo già la funzione che nel caso in cui non
        // trova l'id restituisce un null di per se
        // if (id != 0 && id >= 1) {} return null

        // calcolando che il findbyid restituisce un optional ( se non trova nulla
        // potrebbe essere vuoto )
        // mentre il mapper vuole un teacher e quindi dobbiamo estrarlo dall'optional

        return repo.findById(id)
                .map(teach -> mapper.toDTO(teach))
                // .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Utente con id:" + id + " non esistente."));
    }

    @Override
    public void deleteTeacher(Integer id) {
        Teacher teach = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utente con id:" + id + " non esistente."));
        repo.delete(teach);
        // if (id == 0 || id == null) {
        // return false;
        // }
        // if (!repo.existsById(id)) {
        // return false;
        // }
        // repo.deleteById(id);
        // return true;
    }

    @Override
    public TeacherDTO saveTeacher(TeacherDTO teachDTO) {
        // se l'utente creato è diverso da null
        if (teachDTO == null) {
            throw new IllegalArgumentException("Tutti i campi devono essere compilati");
        }
        // creiamo l'entità e la mappiamo all'oggetto creato e la salviamo
        Teacher teacher = mapper.toEntity(teachDTO);
        Teacher savedTeacher = repo.save(teacher);
        // ci facciamo restituire sempre un dto
        // cosi' come in student dato che nel dto comunque non richiediamo l'id e non lo
        // autogenera dobbiamo prendercelo dall'entity
        // teachDTO.setId(teacher.getId());
        return mapper.toDTO(savedTeacher);

    }

    @Override
    public TeacherDTO updateTeacher(Integer id, TeacherDTO newTeach) {

        Teacher teach = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utente con id: " + id + "non trovato"));

        // metodo con il mapper
        teach.setFirstName(newTeach.firstName());
        teach.setLastName(newTeach.lastName());
        teach.setTeacherSub(newTeach.teacherSub());
        Teacher updatedTeach = repo.save(teach);
        // altrimenti dato che non richiediamo l'id ci restituisce comunque un dto con
        // l'id null perchè non lo autogenera
        // newTeach.setId(updatedTeacher.getId());
        return mapper.toDTO(updatedTeach);

    }

}
