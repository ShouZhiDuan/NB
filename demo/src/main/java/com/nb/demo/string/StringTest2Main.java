package com.nb.demo.string;

public class StringTest2Main {

    private static String msg = "666";

    private static String msg2 = "666";
    private static String msg3 = "888";

    public static void main(String[] args){
        String s1="abc";
        String s2="abc";
        System.out.println(s1==s2); //true

        String s3=new String("ab") + "c";
        s3.intern();
        String s4="abc";
        System.out.println(s1==s3); //true

        String s5=new String("ab")+new String("cd");
        s5.intern();
        String s6="abcd";
        System.out.println(s5==s6); //true
    }

}