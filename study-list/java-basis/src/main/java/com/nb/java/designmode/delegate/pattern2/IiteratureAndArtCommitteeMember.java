package com.nb.java.designmode.delegate.pattern2;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName IiteratureAndArtCommitteeMember
 * @author: duanshouzhi
 * @create: 2023-07-08 22:53
 * @description: 文艺委员
 **/
public class IiteratureAndArtCommitteeMember implements Student{

    @Override
    public void registrationProgram(String role) {
        System.out.println("我是文艺委员：我要报名表演唱歌");
    }
}