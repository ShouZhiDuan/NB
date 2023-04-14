package com.nb.demo.string;

public class StringTestMain {
    static final int MAX = 1000 * 10000;
    static final String[] arr = new String[MAX];

    public static void main(String[] args) throws Exception {
        String txt3 = "666666";
        System.out.println("txt3=" + String.class.getName() + "@" + Integer.toHexString(System.identityHashCode(txt3)));

        String txt = new String("666666");
        System.out.println("txt=" + String.class.getName() + "@" + Integer.toHexString(System.identityHashCode(txt)));

        String intern = txt.intern();
        System.out.println("intern=" + String.class.getName() + "@" + Integer.toHexString(System.identityHashCode(intern)));

        String txt2 = "666666";
        System.out.println("txt2=" + String.class.getName() + "@" + Integer.toHexString(System.identityHashCode(txt2)));

    }
}
