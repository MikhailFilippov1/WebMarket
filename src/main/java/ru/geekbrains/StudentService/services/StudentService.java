package ru.geekbrains.StudentService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.StudentService.model.Student;
import ru.geekbrains.StudentService.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findById(Long id){
        return studentRepository.findById(id);
    }

    public void saveStudent(Student student){
        Student createdStudent = new Student();
        createdStudent.setId((long) (studentRepository.findAll().size() + 1));
        createdStudent.setAge(student.getAge());
        createdStudent.setName(student.getName());
        studentRepository.saveStudent(createdStudent);
    }

    public void updateStudent(Student student){
        Student updatedStudent = studentRepository.findById(student.getId());
        updatedStudent.setName(student.getName());
        updatedStudent.setAge(student.getAge());
        studentRepository.updateStudent(updatedStudent);
    }

    public boolean deleteStudent(Long id){
        return studentRepository.deleteStudent(id);
    }

    public void changeAge(Long id, int delta){
        Student student = studentRepository.findById(id);
        student.setAge(student.getAge() + delta);
    }
}
