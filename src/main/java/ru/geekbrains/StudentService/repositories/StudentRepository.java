package ru.geekbrains.StudentService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.StudentService.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
