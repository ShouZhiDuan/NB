package com.nb.digest.util.test;

import cn.hutool.crypto.digest.DigestUtil;

import java.util.Base64;
import java.util.Date;

public class DigestTestMain {

    private final  static  String NV_APP_KEY = "QWER@123456";
    private final  static  String NV_APP_SECRET = "66666656789012345678901234888888";
    private final  static String salt = "2400c2f4412f4545ab8c523bfc0957af";
    private final  static String nonce = "1681211671988";

    public static void main(String[] args){
        String uph = getUph(NV_APP_KEY, NV_APP_SECRET);
        String sph = getSph(salt, uph);
        String digest = DigestUtil.sha256Hex(sph + nonce);
        System.err.println(digest);

        byte[] base64Token = Base64.getDecoder().decode("eyJleHBpcmVUaW1lIjoxNjgxMjk4MTQyMDQ2LCJzdGFydFRpbWUiOjE2ODEyMTE3NDIwNDZ9");
        String tokenStr = new String(base64Token);
        System.err.println(tokenStr);


        Date date = new Date(1681298142046L);
        System.out.println(date);




    }

    private static String getSph(String salt, String uph) {
        return DigestUtil.sha256Hex(salt + uph);
    }

    private static String getUph(String nvAppKey, String nvAppSecret) {
        return  DigestUtil.sha256Hex(nvAppKey + nvAppSecret);
    }


}
