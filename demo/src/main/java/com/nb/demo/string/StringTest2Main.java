package com.nb.demo.string;

public class StringTest2Main {

    private static String msg = "666";

    private static String msg2 = "666";
    private static String msg3 = "888";

    public static void main(String[] args){
        //String s1="abc";
        //String s2="abc";
        //System.out.println(s1==s2);
        String s3=new String("ab")+new String("c");
        System.out.println("987987");
        s3.intern();
        String s1="abc";
        System.out.println(s1==s3);

        String s4=new String("ab")+new String("cd");
        s4.intern();
        String s5="abcd";
        System.out.println(s4==s5);
    }

}