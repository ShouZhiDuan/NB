package com.nb.java.designmode.prototype;

import java.io.Serializable;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName Teacher
 * @author: duanshouzhi
 * @create: 2023-06-19 14:30
 * @description:
 **/
public class Teacher implements Cloneable, Serializable {

    private String name;

    private Integer age;

    private Student student;

    public Teacher(String name, Integer age, Student student) {
        this.name = name;
        this.age = age;
        this.student = student;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}