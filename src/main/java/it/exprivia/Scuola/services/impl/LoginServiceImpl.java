package it.exprivia.Scuola.services.impl;

import it.exprivia.Scuola.exception.UnauthorizedException;
import it.exprivia.Scuola.mapper.StudentMapper;
import it.exprivia.Scuola.mapper.TeacherMapper;
import it.exprivia.Scuola.models.dto.LoginRequest;
import it.exprivia.Scuola.models.dto.LoginResponse;
import it.exprivia.Scuola.models.entity.Student;
import it.exprivia.Scuola.models.entity.Teacher;
import it.exprivia.Scuola.repositories.StudentRepository;
import it.exprivia.Scuola.repositories.TeacherRepository;
import it.exprivia.Scuola.services.ILogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class LoginServiceImpl implements ILogin {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private StudentRepository studentRepo;
    private TeacherRepository teacherRepo;
    private StudentMapper studentMapper;
    private TeacherMapper teacherMapper;

    // Costruttore per la Dependency Injection
    public LoginServiceImpl(BCryptPasswordEncoder passwordEncoder,
                            StudentRepository studentRepo,
                            TeacherRepository teacherRepo,
                            StudentMapper studentMapper,
                            TeacherMapper teacherMapper) {
        this.passwordEncoder = passwordEncoder;
        this.studentRepo = studentRepo;
        this.teacherRepo = teacherRepo;
        this.teacherMapper = teacherMapper;
        this.studentMapper = studentMapper;
    }


    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        // cerchiamo lo studente
        Optional<Student> studOpt = studentRepo.findByUsername(loginRequest.username());
        if (studOpt.isPresent()) {
            Student stud = studOpt.get();
            if (!passwordEncoder.matches(loginRequest.password(), stud.getPassword())) {
                throw new UnauthorizedException("Username o password errati.");
            }
            return new LoginResponse("Login effettuato con successo", "STUDENT", studentMapper.toDTO(stud));
        }

        Optional<Teacher> teachOpt = teacherRepo.findByUsername(loginRequest.username());
        if (teachOpt.isPresent()) {
            Teacher teach = teachOpt.get();
            if (!passwordEncoder.matches(loginRequest.password(), teach.getPassword())) {
                throw new UnauthorizedException("Username o password errati.");
            }
            return new LoginResponse("Login effettuato con successo", "TEACHER", teacherMapper.toDTO(teach));
        }

        throw new UnauthorizedException("Username o password errati.");

    }
}

//        Student stud = studentRepo.findByUsername(username).
//                orElseThrow(() -> new UnauthorizedException("Username o password errati."));
//        Teacher teach = teacherRepo.findByUsername(username).
//                orElseThrow(() -> new UnauthorizedException("Username o password errati."));
//
//        if (!passwordEncoder.matches(password, stud.getPassword()) || !passwordEncoder.matches(password, teach.getPassword())) {
//            throw new UnauthorizedException("Username o password errati.");
//        }

//        String storedPassword = studentRepo.findByUsername(username)
//                .map(stud -> stud.getPassword())
//                .orElseGet(() -> teacherRepo.findByUsername(username)
//                        .map(teach -> teach.getPassword())
//                        .orElseThrow(() -> new UnauthorizedException("Username o password errati.")));
//
//        if (!passwordEncoder.matches(password, storedPassword)) {
//            throw new UnauthorizedException("Username o password errati.");
//        }
//        return new LoginResponse("Login effettuato con successo")


