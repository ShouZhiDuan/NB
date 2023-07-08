package com.nb.java.designmode.delegate.pattern2;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName StudyCommitteeMember
 * @author: duanshouzhi
 * @create: 2023-07-08 22:51
 * @description: 学习委员
 **/
public class StudyCommitteeMember implements Student{

    @Override
    public void registrationProgram(String role) {
        System.out.println("我是学习委员：我要报名朗诵古诗");
    }
}