package org.daylily.modules.student.controller;

import org.daylily.modules.student.util.Result;
import org.daylily.modules.student.entity.Student;
import org.daylily.modules.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Resource
    private StudentService studentService;

    //TODO: 怎么不需要配置就可以？ 怎么配置成前端传body的post
    //添加一个学生
    //@ApiOperation(value = "添加一个学生", notes = "根据Student对象创建学生", produces = "application/x-www-form-urlencoded, application/json")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "name", value = "学生姓名", required = true, dataType = "String"),
    //        @ApiImplicitParam(name = "age", value = "学生年龄", required = false, dataType = "Integer")
    //})
    @PostMapping(value = "/addStudent")
    public Result addStudent(Student student) {
        Result result = new Result();
        try {
            studentService.addStudent(student);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    //修改一个学生(jpa是根据id来修改的)
    @PutMapping(value = "/updateStudent")
    public Result updateStudentById(Student student) {
        Result result = new Result();
        try {
            studentService.updateStudent(student);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    //根据id删除一条数据
    @DeleteMapping(value = "/deleteStudent/{id}")
    public Result deleteStudentById(@PathVariable(name = "id", required = true) Long id) {
        Result result = new Result();
        try {
            studentService.deleteStudentById(id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    //查询所有
    @GetMapping(value = "/findAll")
    public Result findAll() {
        Result result = new Result();
        try {
            List<Student> list = studentService.findAll();
            //将查询结果封装到CommonResult中
            result.setData(list);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    //根据id查询一条数据(2.0后不能使用findOne了)
    @GetMapping(value = "/findStudentById/{id}")
    public Result findStudentById(@PathVariable(name = "id") Long id) {
        Result result = new Result();
        try {
            Student student = studentService.findStudentById(id);
            //将查询结果封装到CommonResult中
            result.setData(student);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    //根据学生姓名查询多条数据
    @GetMapping(value = "/findStudentByName")
    public Result findStudentByName(String name) {
        Result result = new Result();
        try {
            List<Student> studentList = studentService.findStudentByName(name);
            //将查询结果封装到CommonResult中
            result.setData(studentList);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }
}
