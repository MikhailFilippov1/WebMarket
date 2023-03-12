package ru.geekbrains.StudentService.repositories;

import org.springframework.stereotype.Repository;
import ru.geekbrains.StudentService.model.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> studentList;

    @PostConstruct
    public void init(){
        this.studentList = new ArrayList<>(Arrays.asList(
                new Student(1L, "Bob", 18),
                new Student(2L, "Bill", 19),
                new Student(3L, "Mary", 20),
                new Student(4L, "Peter", 21),
                new Student(5L, "Debora", 22)
        ));
    }

    public List<Student> findAll(){
        return Collections.unmodifiableList(studentList);
    }

    public Student findById(Long id){
        return studentList.stream().filter(student -> student.getId().equals(id)).findFirst().get();
    }

    public void saveStudent(Student student){
        studentList.add(student);
    }

    public void updateStudent(Student student){
        studentList.set(Math.toIntExact(student.getId() - 1),student);
    }

    public boolean deleteStudent(Long id){
        return studentList.removeIf(student -> student.getId().equals(id));
    }
}
