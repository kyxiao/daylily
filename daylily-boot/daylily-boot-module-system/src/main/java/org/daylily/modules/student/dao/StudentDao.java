package org.daylily.modules.student.dao;

import org.daylily.modules.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Long> {
    public List<Student> findByName(String name);
}
