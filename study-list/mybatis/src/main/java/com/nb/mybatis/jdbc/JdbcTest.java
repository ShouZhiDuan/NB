package com.nb.mybatis.jdbc;


/**
 * @author dev
 */
public class JdbcTest {


    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println(aClass);
    }

}
