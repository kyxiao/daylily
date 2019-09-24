package org.daylily.modules.student.entity;

import javax.persistence.*;

@Entity(name = "tb_student")
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 32)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 3)
    private Integer age;
    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
