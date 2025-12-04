package it.exprivia.Scuola.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.exprivia.Scuola.mapper.TeacherMapper;
import it.exprivia.Scuola.models.dto.TeacherDTO;
import it.exprivia.Scuola.models.entity.Teacher;
import it.exprivia.Scuola.repositories.IPersonRepository;
import it.exprivia.Scuola.services.ITeacher;

@Service
public class TeacherServiceImpl implements ITeacher {

    @Autowired
    private IPersonRepository<Teacher> repo;

    // inject del mapper
    @Autowired
    private TeacherMapper mapper;

    @Override
    public List<TeacherDTO> getAllTeachers() {
        // puoi mappare direttamente la lista dal mapstruct e convertire tutte le entità
        // che hai nel repository in una lista dtos
        List<TeacherDTO> dtos = mapper.toDTOList(repo.findAll());
        return dtos;
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
                .orElse(null);
    }

    @Override
    public boolean deleteTeacher(Integer id) {
        if (id == 0 || id == null) {
            return false;
        }
        if (!repo.existsById(id)) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }

    @Override
    public TeacherDTO saveTeacher(TeacherDTO teachDTO) {
        // se l'utente creato è diverso da null
        if (teachDTO != null) {
            // creiamo l'entità e la mappiamo all'oggetto creato e la salviamo
            Teacher teacher = mapper.toEntity(teachDTO);
            repo.save(teacher);
            // ci facciamo restituire sempre un dto
            // cosi' come in student dato che nel dto comunque non richiediamo l'id e non lo
            // autogenera dobbiamo prendercelo dall'entity
            teachDTO.setId(teacher.getId());
            return teachDTO;
        }
        return null;
    }

    @Override
    public TeacherDTO updateTeacher(Integer id, TeacherDTO newTeach) {

        Optional<Teacher> teach = repo.findById(id);

        if (teach.isPresent()) {
            // metodo con il mapper
            Teacher updatedTeacher = teach.get();
            updatedTeacher.setFirstName(newTeach.getFirstName());
            updatedTeacher.setLastName(newTeach.getLastName());
            updatedTeacher.setTeacherSub(newTeach.getTeacherSub());
            repo.save(updatedTeacher);
            // altrimenti dato che non richiediamo l'id ci restituisce comunque un dto con l'id null perchè non lo autogenera
            newTeach.setId(updatedTeacher.getId());
            return mapper.toDTO(updatedTeacher);
        }
        return null;
    }

}
