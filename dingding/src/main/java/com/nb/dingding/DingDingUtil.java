package com.nb.dingding;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.nb.dingding.config.DingDingPushConfigProperties;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author dev
 */

@Slf4j
@Component
public class DingDingUtil {

    private final DingDingPushConfigProperties dingDingPushConfigProperties;

    private  OkHttpClient okHttpClient;
    private  String url;

    public DingDingUtil(DingDingPushConfigProperties dingDingPushConfigProperties){
        log.info("【钉钉】：初始化组件");
        this.dingDingPushConfigProperties = dingDingPushConfigProperties;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10L, TimeUnit.SECONDS);
        builder.readTimeout(10L, TimeUnit.SECONDS);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(200);
        dispatcher.setMaxRequests(200);
        builder.dispatcher(dispatcher);
        okHttpClient = builder.build();
    }


    /**
     * 通用 POST 请求方法  依赖 OKhttp3
     * @param message 所要发送的消息
     * @return 发送状态回执
     */
    public String postWithJson(String message) {

        log.info(dingDingPushConfigProperties.getBaseurl());
        log.info(dingDingPushConfigProperties.getToken());
        log.info(dingDingPushConfigProperties.getSecret());

        if(StringUtils.isBlank(dingDingPushConfigProperties.getBaseurl())
                || StringUtils.isBlank(dingDingPushConfigProperties.getToken())
                || StringUtils.isBlank(dingDingPushConfigProperties.getSecret())){
            log.error("【钉钉】：请配置钉钉环境变量：dingding.baseurl dingding.token dingding.secret");
            return null;
        }

        if(StringUtils.isBlank(url)){
            try {
                url = getSign();
            } catch (Exception e) {
                log.error("【钉钉】：{}", e);
                throw new RuntimeException(e);
            }
        }

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

        String baseUrl = dingDingPushConfigProperties.getBaseurl();
        String token = dingDingPushConfigProperties.getToken();
        String secret = dingDingPushConfigProperties.getSecret();

        if(StringUtils.isBlank(dingDingPushConfigProperties.getBaseurl())
                || StringUtils.isBlank(dingDingPushConfigProperties.getToken())
                || StringUtils.isBlank(dingDingPushConfigProperties.getSecret())){
            log.error("【钉钉】：请配置钉钉环境变量：dingding.baseurl dingding.token dingding.secret");
            return null;
        }

        long timestamp = System.currentTimeMillis();
        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
        return baseUrl + token + "&timestamp=" + timestamp + "&sign=" +
                URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
    }

}
