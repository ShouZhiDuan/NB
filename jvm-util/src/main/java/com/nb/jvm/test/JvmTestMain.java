package com.nb.jvm.test;

public class JvmTestMain {

    private static String msg = "666";

    private static String msg2 = "666";
    private static String msg3 = "888";

    public static void main(String[] args){
        String s1="abc";
        String s2="abc";
        System.out.println(s1==s2);//true
        String s3=new String("ab")+new String("c");

        // 这里显示false，可能先在字符串常量池中添加s1，然后动态的添加s3，会显示false
        s3.intern();
        System.out.println(s1==s3); //false

        String s4=new String("ab")+new String("cd");
        s4.intern();
        String s5="abcd";
        System.out.println(s4==s5);//true,去掉intern之后是false;
    }
}
