package com.nb.digest.util;

import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;
import javax.security.auth.x500.X500Principal;
import java.io.File;
import java.io.IOException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;


public class CrtUtil {
    public static KeyPair genKeyPair() throws NoSuchAlgorithmException {

        KeyPair keyPair = null;

        if(!OpenSslUtil.isPriKeyExists() || !OpenSslUtil.isCsrExists()){
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(3072);
            keyPair = kpg.genKeyPair();
            // export pub pri key
            exportKeyFile(keyPair);
            return keyPair;
        }
        // load local key
        keyPair = new KeyPair(
                getPublicKey(OpenSslUtil.getEncodedPubKeyTxt()),
                getPrivateKey(OpenSslUtil.getEncodedPriKeyTxt())
        );

        return keyPair;
    }


    /**
     * 生成签名
     */
    public static String genBase64Signature(String planTxt) throws Exception {

        KeyPair keyPair = genKeyPair();

        byte[] data = planTxt.getBytes("UTF8");

        Signature sig = Signature.getInstance("SHA1WithRSA");
        PrivateKey privateKey = keyPair.getPrivate();
        sig.initSign(privateKey);
        sig.update(data);

        byte[] signatureBytes = sig.sign();
        String base64Signature =
                org.apache.commons.codec.binary.Base64.encodeBase64String(signatureBytes);
        System.out.println("签名结果：" + base64Signature);

        // TODO 保存签名后的内容base64
        OpenSslUtil.txtToFile(base64Signature, "base64Signature.txt");

        return base64Signature;
    }

    /**
     * 测试输出签名
     */
    public static void main(String[] args) throws Exception {
        genBase64Signature("testName");
    }


    /**
     * <p>
     *     server.key
     *     server_pub.key
     *     server.csr
     * </p>
     * @param keyPair 秘钥对
     */
    public static void exportKeyFile(KeyPair keyPair){
        String KEY_VALUE = null;
        String PUB_KEY_VALUE = null;
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        // 私钥
        try {
            KEY_VALUE = OpenSslUtil.printOpensslPemFormatKeyFileContent(privateKey, true);
        } catch (IOException e) {
            throw new RuntimeException("获取私钥文本异常");
        }
        // 公钥
        try {
            PUB_KEY_VALUE = OpenSslUtil.printOpensslPemFormatPubKeyFileContent(publicKey, true);
        } catch (IOException e) {
            throw new RuntimeException("获取公钥文本异常");
        }
        X500Principal subject = new X500Principal("C=CN, ST=ZJ, S=浙江, L=杭州, O=NV, OU=168168, CN=nvxclouds.com, EMAILADDRESS=dahua@nvxclouds.com");
        // 使用私钥和SHA256WithRSA/SM3withSM2算法创建签名者对象
        ContentSigner signer = null;
        try {
            signer = new JcaContentSignerBuilder("SHA256WithRSA").build(privateKey);
        } catch (OperatorCreationException e) {
            throw new RuntimeException(e);
        }
        // 创建 CSR
        PKCS10CertificationRequestBuilder builder = new JcaPKCS10CertificationRequestBuilder(subject, publicKey);
        PKCS10CertificationRequest csr = builder.build(signer);
        // 打印 OpenSSL PEM 格式文件字符串
        String CSR_VALUE = null;
        try {
            CSR_VALUE = OpenSslUtil.printOpensslPemFormatCsrFileContent(csr);
        } catch (IOException e) {
            throw new RuntimeException("获取CSR文本异常");
        }
        File certDir = new File("cert");
        if(!certDir.exists()){
            certDir.mkdirs();
        }



        //获取公、私钥值
        String PUBLICKEY_ENCODED_VALUE = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String PRIVATEKEY_ENCODED_VALUE = Base64.getEncoder().encodeToString(privateKey.getEncoded());

        OpenSslUtil.txtToFile(PUBLICKEY_ENCODED_VALUE,"encoded_pub.key");
        OpenSslUtil.txtToFile(PRIVATEKEY_ENCODED_VALUE,"encoded_pri.key");

        OpenSslUtil.txtToFile(KEY_VALUE,"server.key");
        OpenSslUtil.txtToFile(PUB_KEY_VALUE,"server_pub.key");
        OpenSslUtil.txtToFile(CSR_VALUE, "server.csr");
    }


    /**
     * 解码PublicKey
     * @param key
     * @return
     */
    public static PublicKey getPublicKey(String key) {
        try {
            byte[] byteKey = Base64.getDecoder().decode(key);
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(byteKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(x509EncodedKeySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 解码PrivateKey
     * @param key
     * @return
     */
    public static PrivateKey getPrivateKey(String key) {
        try {
            byte[] byteKey = Base64.getDecoder().decode(key);
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(byteKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
