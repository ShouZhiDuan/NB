package com.nb.demo.string;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

public class StringTest3 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(8);

        list.removeAll(list2);

        System.out.println(list.size());


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("test","test value");

        jsonObject.remove("test");

        System.out.println(jsonObject);


        String txt = "";

        String[] split = txt.split("\\,");

        System.out.println(split);


    }
}

