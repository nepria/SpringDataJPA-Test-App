package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public final StudentRepository studentRepository;

    public List<Student> getMapping() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("Email Already exisits");
        }
        studentRepository.save(student);
    }

    public void deletestudent(Long studentId) {
         boolean exists = studentRepository.existsById(studentId);
         if(!exists) {
             throw new IllegalStateException("Student does not exists");
         }
         studentRepository.deleteById(studentId);
    }
}
