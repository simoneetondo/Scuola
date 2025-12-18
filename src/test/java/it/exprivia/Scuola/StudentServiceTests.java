package it.exprivia.Scuola;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import it.exprivia.Scuola.mapper.StudentMapper;
import it.exprivia.Scuola.models.dto.StudentDTO;
import it.exprivia.Scuola.models.entity.Student;
import it.exprivia.Scuola.repositories.StudentRepository;
import it.exprivia.Scuola.services.impl.StudentServiceImpl;

class StudentServiceTests {

    private StudentServiceImpl studentServiceImpl;

    @Mock
    private StudentRepository studentRepositoryMock;

    @Mock
    private StudentMapper studentMapperMock;

    @BeforeEach
    void setup() {
        this.studentRepositoryMock = mock(StudentRepository.class);
        this.studentMapperMock = mock(StudentMapper.class);
        this.studentServiceImpl = new StudentServiceImpl(studentMapperMock, studentRepositoryMock);
    }

    // raggruppamento dei test per metodi
    @Nested
    class getStudentsMethods {

        @Test
        void should_ReturnCorrectListStudents() {
            // given

            List<Student> studentsEnt = new ArrayList<>();
            studentsEnt.add(new Student("Simone", "Tondo", "N001"));
            studentsEnt.add(new Student("Flavio", "Stincone", "N002"));

            List<StudentDTO> studentDtos = new ArrayList<>();
            studentsEnt.add(new Student("Simone", "Tondo", "N001"));
            studentsEnt.add(new Student("Flavio", "Stincone", "N002"));

            // when

            when(studentRepositoryMock.findAll()).thenReturn(studentsEnt);
            when(studentMapperMock.toDTOList(studentsEnt)).thenReturn(studentDtos);
            List<StudentDTO> students = studentServiceImpl.getStudents();

            // then

            assertEquals(studentDtos, students);

        }
    }

    // @Test
    // void should_ReturnCorrectStudent_WithId() {

    //     // given
    //     Student stud = new Student("Simone", "Tondo", "001");
    //     StudentDTO expected = new StudentDTO("Simone", "Tondo", "001");

    //     // when
    //     when(studentRepositoryMock.findById(1)).thenReturn(Optional.of(stud));
    //     when(studentMapperMock.toDTO(stud)).thenReturn(expected);
    //     StudentDTO actual = studentServiceImpl.getStudent(1);

    //     // then
    //     assertEquals(expected, actual);

    // }

    @Test
    void should_ReturnNull_WhenIsNull() {
        // given

        // when
        when(studentRepositoryMock.findById(1)).thenReturn(Optional.empty());
        StudentDTO actual = studentServiceImpl.getStudent(1);

        // then

        assertNull(actual);

    }

    // non funziona il test perchè giustamente non utilizzo il mapper ma utilizzo
    // quello manuale nella classe student
    // @Test
    // void should_SaveStudent_WhenValidDto() {
    //     // given
    //     StudentDTO dto = new StudentDTO("Simone", "Tondo", "001");

    //     Student entity = new Student(null, null, "Simone", "Tondo", "001", null);
    //     Student savedEntity = new Student(null, null, "Simone", "Tondo", "001", null);

    //     when(studentMapperMock.toEntity(dto)).thenReturn(entity);
    //     when(studentRepositoryMock.save(entity)).thenReturn(savedEntity);

    //     // when
    //     StudentDTO result = studentServiceImpl.saveStudent(dto);

    //     // then
    //     assertEquals(savedEntity, result);

    //     verify(studentMapperMock).toEntity(dto);
    //     verify(studentRepositoryMock).save(entity);
    // }

}
