package ru.geekbrains.StudentService.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.StudentService.model.Student;
import ru.geekbrains.StudentService.services.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController<ResponseEntity> {
    private StudentService studentService;

    @GetMapping
    public List<Student> showStudentsList(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id){
        return studentService.findById(id).orElseThrow(() -> new RuntimeException("Student id: " + id + " not found"));
    }

    @PostMapping
    public void saveStudent(@RequestBody Student student){
        studentService.save(student);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
         studentService.deleteById(studentId);
    }

    @GetMapping("/student/changeAge")
    public void changeAge(@RequestParam Long studentId, @RequestParam int delta ){
        studentService.changeAge(studentId, delta);
    }
}
