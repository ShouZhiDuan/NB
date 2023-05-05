package com.nb.dingding;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @author dev
 */

@Slf4j
@Service
public class DingDingUtil {

    @Value("${DING_BASE_URL}")
    private String DING_BASE_URL;
    @Value("${DING_TOKEN}")
    private String DING_TOKEN;
    @Value("${DING_SECRET}")
    private String DING_SECRET;

    private  OkHttpClient okHttpClient;
    private  String url;

    public DingDingUtil(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10L, TimeUnit.SECONDS);
        builder.readTimeout(10L, TimeUnit.SECONDS);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(200);
        dispatcher.setMaxRequests(200);
        builder.dispatcher(dispatcher);
        okHttpClient = builder.build();
        try {
            if(StringUtils.isBlank(DING_BASE_URL)
                    || StringUtils.isBlank(DING_TOKEN)
                    || StringUtils.isBlank(DING_SECRET)){

            }
            url = getSign();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 通用 POST 请求方法  依赖 OKhttp3
     * @param message 所要发送的消息
     * @return 发送状态回执
     */
    public String postWithJson(String message) {
        //这里@为全体成员，可具体@某个人只需加上手机号即可
        String str="{ \"at\": { \"isAtAll\": true }, \"text\": { \"content\": \" %s \"}, \"msgtype\":\"text\" }";
        String format = String.format(str, message);
        JSONObject jsonObject = JSON.parseObject(format);
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"), jsonObject.toJSONString());
        Request request = new Request.Builder().url(url).post(body).build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取签名
     * @return 返回签名
     */
    private String getSign() throws Exception {

        //String baseUrl = "https://oapi.dingtalk.com/robot/send?access_token=";
        //String token = "73c0484011841db64bebcaebe448f997cb2053c67c605c9a0048caaf74a43ba0";
        //String secret = "SECa0234a80f393ed75e25d22c486c9f26da77bf1e1984e7b0c5add125fb5491cf1";

        String baseUrl = DING_BASE_URL;
        String token = DING_TOKEN;
        String secret = DING_SECRET;

        long timestamp = System.currentTimeMillis();
        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
        return baseUrl + token + "&timestamp=" + timestamp + "&sign=" +
                URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
    }

}
