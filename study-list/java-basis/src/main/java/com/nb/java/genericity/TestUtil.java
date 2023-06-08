package com.nb.java.genericity;

import com.nb.java.designmode.decorator.Car;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName TestUtil
 * @author: duanshouzhi
 * @create: 2023-06-06 18:06
 * @description:
 **/
public class TestUtil {

    public static <T> Map obj2Map(T obj) throws Exception {
        Map map = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }
        return map;
    }

    public static <M> Object removeField(M obj) throws Exception {
        Set<String> fieldSet = new HashSet<String>();
        fieldSet.add("password");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (fieldSet.contains(field.getName())) {
                field.setAccessible(true);
                field.set(obj, null);
            }
        }
        return obj;
    }

    public static <M> Object removeField(M obj, List<?> list) throws Exception {
        Set<String> fieldSet = new HashSet<String>();
        fieldSet.add("password");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (fieldSet.contains(field.getName())) {
                field.setAccessible(true);
                field.set(obj, null);
            }
        }


        return obj;
    }

    public static void main(String[] args){
        long a = 1;
        long b = 5;
        double result = a/b;
        // 创建DecimalFormat对象，指定保留两位小数
        DecimalFormat decimalFormat = new DecimalFormat("#0.000");
         // 使用DecimalFormat格式化浮点数结果，得到字符串形式的结果
        String formattedResult = decimalFormat.format(result);
        System.out.println("6666666666666666 = " + result);
    }

}