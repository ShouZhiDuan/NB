package com.nb.java.designmode.delegate.pattern2;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName Teacher
 * @author: duanshouzhi
 * @create: 2023-07-08 23:02
 * @description:
 **/
public class Teacher {

    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void command(String role){
        student.registrationProgram(role);
    }

}