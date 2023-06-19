package com.nb.java.designmode.prototype;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName Student
 * @author: duanshouzhi
 * @create: 2023-06-19 15:58
 * @description:
 **/
public class Student {

    private String stdName;
    private Integer stdAge;

    public Student(String stdName, Integer stdAge) {
        this.stdName = stdName;
        this.stdAge = stdAge;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public Integer getStdAge() {
        return stdAge;
    }

    public void setStdAge(Integer stdAge) {
        this.stdAge = stdAge;
    }
}