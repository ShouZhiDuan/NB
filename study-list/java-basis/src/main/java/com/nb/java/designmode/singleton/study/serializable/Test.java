package com.nb.java.designmode.singleton.study.serializable;

import java.io.*;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName Test
 * @author: duanshouzhi
 * @create: 2023-06-15 14:58
 * @description:
 **/
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SerializableSingleton singleton = SerializableSingleton.getSingleton();

        /**
         * 输出对象
         */
        FileOutputStream fileOutputStream =
                new FileOutputStream("study-list/java-basis/src/main/java/com/nb/java/designmode/singleton/study/serializable/SerializableSingleton.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(singleton);


        /**
         * 载入对象
         */
        FileInputStream fileInputStream =
                new FileInputStream("study-list/java-basis/src/main/java/com/nb/java/designmode/singleton/study/serializable/SerializableSingleton.obj");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SerializableSingleton singleton2 = (SerializableSingleton) objectInputStream.readObject();


    }
}