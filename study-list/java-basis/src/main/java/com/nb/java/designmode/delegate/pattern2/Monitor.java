package com.nb.java.designmode.delegate.pattern2;

import java.util.HashMap;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName Monitor
 * @author: duanshouzhi
 * @create: 2023-07-08 22:55
 * @description: 班长
 **/
public class Monitor implements Student{

    private final static HashMap<String,Student> STUDENT_HASH_MAP;

    static {
        // power of 2 for hashmap
        STUDENT_HASH_MAP = new HashMap<>(4);
        STUDENT_HASH_MAP.put("学习委员",new StudyCommitteeMember());
        STUDENT_HASH_MAP.put("劳动委员",new CommissaryInChargeOfPhysicalLabor());
        STUDENT_HASH_MAP.put("文艺委员",new IiteratureAndArtCommitteeMember());
    }

    @Override
    public void registrationProgram(String role) {
        Student student = STUDENT_HASH_MAP.get(role);
        student.registrationProgram(role);
    }
}