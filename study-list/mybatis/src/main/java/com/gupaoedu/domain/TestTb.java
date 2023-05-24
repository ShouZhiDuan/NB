package com.gupaoedu.domain;

import lombok.Data;

/**
 * @author shouzhi@duan
 */

@Data
public class TestTb {

    private Integer id;

    private String name;


    @Override
    public String toString() {
        return "TestTb{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}