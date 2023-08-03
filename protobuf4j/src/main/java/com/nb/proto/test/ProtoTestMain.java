package com.nb.proto.test;

import com.alibaba.fastjson2.JSON;
import com.nb.proto.dto.TestProto;

/**
 * @author duanshouzhi
 * @create 2023-08-03 10:20
 */
public class ProtoTestMain {

    public static void main(String[] args) {
        TestProto.Request build = TestProto.Request.newBuilder().setName("666").build();
        System.out.println(JSON.toJSONString(build));
    }
}
