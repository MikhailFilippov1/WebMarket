package ru.geekbrains.StudentService.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.StudentService.model.Student;
import ru.geekbrains.StudentService.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public Student createNewStudent(Student student){
        Student createdStudent = new Student();
        createdStudent.setName(student.getName());
        createdStudent.setAge(student.getAge());
        studentRepository.save(createdStudent);
        return createdStudent;
    }
    @Transactional
    public void updateStudent(Student student){
        Student updatedStudent = findById(student.getId()).orElseThrow(() -> new RuntimeException("Student id: " + student.getId() + " not found"));
        updatedStudent.setName(student.getName());
        updatedStudent.setAge(student.getAge());
    }

    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }

    public void changeAge(Long id, int delta){
        Student student = findById(id).orElseThrow(() -> new RuntimeException("Student id: " + id + " not found"));
        student.setAge(student.getAge() + delta);
    }
}
