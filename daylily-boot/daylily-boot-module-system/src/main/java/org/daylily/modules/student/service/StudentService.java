package org.daylily.modules.student.service;

import org.daylily.modules.student.entity.Student;
import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudentById(Long id);
    List<Student> findAll();
    Student findStudentById(Long id);
    List<Student> findStudentByName(String name);
}
