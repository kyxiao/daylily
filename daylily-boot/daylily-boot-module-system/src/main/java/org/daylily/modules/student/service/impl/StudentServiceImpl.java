package org.daylily.modules.student.service.impl;

import org.daylily.modules.student.dao.StudentDao;
import org.daylily.modules.student.entity.Student;
import org.daylily.modules.student.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    // 插入一个学生
    public Student addStudent(Student student){
        return studentDao.save(student);
    }
    // 修改一个学生(jpa是根据id来修改的)
    @Override
    public Student updateStudent(Student student){
        return studentDao.save(student);
    }
    // 根据id删除一条数据
    @Override
    public void deleteStudentById(Long id){
        studentDao.deleteById(id);
    }
    // 查询所有
    @Override
    public List<Student> findAll(){
        return studentDao.findAll();
    }
    // 根据id查询一条数据
    @Override
    public Student findStudentById(Long id){
        return studentDao.findById(id).orElse(null);
    }
    //根据学生姓名查询多条数据
    @Override
    public List<Student> findStudentByName(String name){
        return studentDao.findByName(name);
    }
}
