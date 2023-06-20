package com.nb.java.designmode.prototype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName TestMain
 * @author: duanshouzhi
 * @create: 2023-06-19 14:29
 * @description:
 **/
public class TestMain {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    public static void main(String[] args) throws IOException, CloneNotSupportedException, ClassNotFoundException {
        //test(); // 浅拷贝
        test2(); // 深拷贝
    }

    /**
     * 浅拷贝
     */
    private static void test() throws CloneNotSupportedException, JsonProcessingException {
        Student student = new Student("学生", 1);
        Teacher teacher = new Teacher("老师",1, student);

        Teacher clone = (Teacher) teacher.clone();

        System.out.println(OBJECT_MAPPER.writeValueAsString(clone));

        teacher.getStudent().setStdAge(666);

        System.out.println(OBJECT_MAPPER.writeValueAsString(clone));
    }


    /**
     * 深拷贝
     */
    private static void test2() throws IOException, ClassNotFoundException {
        Student student = new Student("学生", 1);
        Teacher teacher = new Teacher("老师",1, student);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(teacher);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Teacher teacher2 = (Teacher) objectInputStream.readObject();

        student.setStdAge(666);

        System.out.println(OBJECT_MAPPER.writeValueAsString(teacher));
        System.out.println(OBJECT_MAPPER.writeValueAsString(teacher2));
    }

}