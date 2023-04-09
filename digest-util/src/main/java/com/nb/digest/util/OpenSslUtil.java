package com.nb.digest.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.auth.x500.X500Principal;
import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Slf4j
public class OpenSslUtil {

    private static final String CHARSET = "utf-8";
    private static final Base64.Decoder decoder64 = Base64.getDecoder();
    private static final Base64.Encoder encoder64 = Base64.getEncoder();

    /**
     * <p>生成密钥对</p>
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws OperatorCreationException
     * @throws IOException
     */
    public static KeyPairData generateCsr(Integer initialize) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, OperatorCreationException, IOException {
        if(initialize == null){
            initialize = 3072;
        }
        // 使用 RSA/ECC 算法，生成密钥对（公钥、私钥）
        //KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", BC);
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        // RSA
        generator.initialize(initialize);

        KeyPair keyPair = generator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // 私钥
        String KEY_VALUE = printOpensslPemFormatKeyFileContent(privateKey, true);
        // 公钥
        String PUB_KEY_VALUE = printOpensslPemFormatPubKeyFileContent(publicKey, true);

        // 按需添加证书主题项
        // 有些 CSR 不需要我们在主题项中添加各字段,
        // 如 `C=CN, OU=3303..., L=杭州, S=浙江`，
        // 而是通过额外参数提交，故这里我只简单地指定了国家码
        X500Principal subject = new X500Principal(
                "C=CN, ST=ZJ, S=浙江, L=杭州, O=NV, OU=168168, " +
                        "CN=nvxclouds.com, EMAILADDRESS=dahua@nvxclouds.com");

        // 使用私钥和 SHA256WithRSA/SM3withSM2 算法创建签名者对象
        ContentSigner signer = new JcaContentSignerBuilder("SHA256WithRSA")
                //.setProvider(BC)
                .build(privateKey);

        // 创建 CSR
        PKCS10CertificationRequestBuilder builder = new JcaPKCS10CertificationRequestBuilder(subject, publicKey);
        PKCS10CertificationRequest csr = builder.build(signer);

        // 打印 OpenSSL PEM 格式文件字符串
        String CSR_VALUE = printOpensslPemFormatCsrFileContent(csr);
        System.out.println(CSR_VALUE);

        // 以 Base64 字符串形式返回 CSR
        //String CSR_BASE64 = Base64.getEncoder().encodeToString(CSR_VALUE.getBytes());
        //System.out.println(CSR_BASE64);
        //return CSR_VALUE;

        return KeyPairData.builder().setPriKey(KEY_VALUE).setCsr(CSR_VALUE).setPubKey(PUB_KEY_VALUE);
    }

   public static class KeyPairData{
        private String priKey;
        private String csr;
        private String pubKey;

        public static KeyPairData builder(){
            return new KeyPairData();
        }

        public String getPriKey() {
            return priKey;
        }

        public KeyPairData setPriKey(String priKey) {
            this.priKey = priKey;
            return this;
        }

        public String getCsr() {
            return csr;
        }

        public KeyPairData setCsr(String csr) {
            this.csr = csr;
            return this;
        }

       public String getPubKey() {
           return pubKey;
       }

       public KeyPairData setPubKey(String pubKey) {
           this.pubKey = pubKey;
           return this;
       }
   }

    /**
     * 获取私钥内容
     * @param privateKey
     * @param isRsaNotEcc
     * @return
     * @throws IOException
     */
    public static String printOpensslPemFormatKeyFileContent(PrivateKey privateKey, boolean isRsaNotEcc) throws IOException {
        PemObject pem = new PemObject(isRsaNotEcc ? "PRIVATE KEY" : "EC PRIVATE KEY", privateKey.getEncoded());
        StringWriter str = new StringWriter();
        PemWriter pemWriter = new PemWriter(str);
        pemWriter.writeObject(pem);
        pemWriter.close();
        str.close();
        return str.toString();
    }

    /**
     * 获取公钥内容
     * @param publicKey
     * @param isRsaNotEcc
     * @return
     * @throws IOException
     */
    public static String printOpensslPemFormatPubKeyFileContent(PublicKey publicKey, boolean isRsaNotEcc) throws IOException {
        PemObject pem = new PemObject(isRsaNotEcc ? "PUBLIC KEY" : "EC PUBLIC KEY", publicKey.getEncoded());
        StringWriter str = new StringWriter();
        PemWriter pemWriter = new PemWriter(str);
        pemWriter.writeObject(pem);
        pemWriter.close();
        str.close();
        return str.toString();
    }

    public static String printOpensslPemFormatCsrFileContent(PKCS10CertificationRequest csr) throws IOException {
        PemObject pem = new PemObject("CERTIFICATE REQUEST", csr.getEncoded());
        StringWriter str = new StringWriter();
        PemWriter pemWriter = new PemWriter(str);
        pemWriter.writeObject(pem);
        pemWriter.close();
        str.close();
        return str.toString();
    }

    /**
     * <p>文本保存到文件</>
     * @param txt 文本内容
     * @param fileNname 文件名
     */
    public static void txtToFile(String txt, String fileNname) {
        // TODO 创建目录
        File dir = new File("cert");
        if(!dir.exists() &&  dir.mkdirs()){
            log.info("目录创建成功");
        }
        FileOutputStream fos = null;
        try {
            File file = new File(dir+File.separator+fileNname);
            fos = new FileOutputStream(file);
            fos.write(txt.getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(fileNname + "：文件未找到");
        } catch (IOException e) {
            throw new RuntimeException(fileNname + "：文件写出异常");
        }finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(fileNname + "：文件输出流关闭异常");
                }
            }
        }
    }

    /**
     * <p>获取私钥</p>
     */
    public static String getPriKeyTxt(){
        File file = new File("cert/server.key");
        if(!file.exists()){
            throw new RuntimeException("未找到当前用户私钥");
        }
        try {
            String keyTxt = FileUtils.readFileToString(file, "UTF-8");
            log.info("PrivateKey：\r\n" + keyTxt);
            return keyTxt;
        } catch (IOException e) {
            throw new RuntimeException("解析私钥异常");
        }
    }


    /**
     * <p>获取公钥</p>
     */
    public static String getPubKeyTxt(){
        File file = new File("cert/server_pub.key");
        if(!file.exists()){
            throw new RuntimeException("未找到当前用户公钥");
        }
        try {
            String pubKeyTxt = FileUtils.readFileToString(file, "UTF-8");
            log.info("PublicKey：\r\n" + pubKeyTxt);
            return pubKeyTxt;
        } catch (IOException e) {
            throw new RuntimeException("解析公钥异常");
        }
    }

    /**
     * <p>获取编码公钥</p>
     */
    public static String getEncodedPubKeyTxt(){
        File file = new File("cert/encoded_pub.key");
        if(!file.exists()){
            throw new RuntimeException("未找到当前用户编码公钥");
        }
        try {
            String encodedPubKeyTxt = FileUtils.readFileToString(file, "UTF-8");
            log.info("EncodedPublicKey：\r\n" + encodedPubKeyTxt);
            return encodedPubKeyTxt;
        } catch (IOException e) {
            throw new RuntimeException("解析编码公钥异常");
        }
    }

    /**
     * <p>获取编码私钥</p>
     */
    public static String getEncodedPriKeyTxt(){
        File file = new File("cert/encoded_pri.key");
        if(!file.exists()){
            throw new RuntimeException("未找到当前用户编码私钥");
        }
        try {
            String encodedPriKeyTxt = FileUtils.readFileToString(file, "UTF-8");
            log.info("EncodedPriKey：\r\n" + encodedPriKeyTxt);
            return encodedPriKeyTxt;
        } catch (IOException e) {
            throw new RuntimeException("解析编码私钥异常");
        }
    }

    /**
     * <p>获取证书</p>
     */
    public static String getCsrTxt(){
        File file = new File("cert/server.csr");
        if(!file.exists()){
            throw new RuntimeException("未找到当前用户证书请求文件");
        }
        try {
            String csrTxt = FileUtils.readFileToString(file, "UTF-8");
            log.info("CSR：\r\n" + csrTxt);
            return csrTxt;
        } catch (IOException e) {
            throw new RuntimeException("解析用户证书请求文件异常");
        }
    }


    /**
     * <p>判断证书请求文件是否存在</p>
     */
    public static boolean isCsrExists(){
        return new File("cert/server.csr").exists();
    }

    /**
     * <p>判断私钥是否存在</p>
     */
    public static boolean isPriKeyExists(){
        return new File("cert/server.key").exists();
    }

    /**
     * <p>判断证书是否存在</p>
     */
    public static boolean isCerExists(){
        return new File("cert/server.cer").exists();
    }

    /**
     * <p>获取证书文本</p>
     */
    public static String getBase64CerTxt(){
        String cerTxt = null;
        try {
            File cer = new File("cert/server.cer");
            if(!cer.exists()){
                throw new RuntimeException("未找到证书文件");
            }
            cerTxt = FileUtils.readFileToString(cer, "UTF-8");
            return cerTxt;
        } catch (IOException e) {
            throw new RuntimeException("获取证书文件内容异常");
        }
    }


    /**
     * 私钥加密
     * @param data
     * @param privateInfoStr
     * @return
     * @throws IOException
     */
    public static String encryptData(String data, String privateInfoStr) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        //Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, getPrivateKey(encoder64.encodeToString(privateInfoStr.getBytes())));
        String finalBase64 = encoder64.encodeToString(cipher.doFinal(data.getBytes(CHARSET)));
        txtToFile(finalBase64,"base64Signature.txt");
        return finalBase64;
    }

    /**
     * 公钥解密
     * @param data
     * @param publicInfoStr
     * @return
     */
    public static String decryptData(String data, String publicInfoStr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        byte[] encryptDataBytes=decoder64.decode(data.getBytes(CHARSET));
        //解密
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, getPublicKey(encoder64.encodeToString(publicInfoStr.getBytes())));
        return new String(cipher.doFinal(encryptDataBytes), CHARSET);
    }
    private static PublicKey getPublicKey(String base64PublicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }
    private static PrivateKey getPrivateKey(String base64PrivateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PrivateKey privateKey = null;
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey.getBytes()));
        KeyFactory keyFactory = null;
        keyFactory = KeyFactory.getInstance("RSA");
        privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    /**
     * 判断chain.pem是否存在
     * isPriKeyExists
     */
    public static Boolean isChainPemExists(){
        File file = new File("pem/chain.pem");
        if(file.exists()){
            return true;
        }
        return false;
    }


    /**
     * 测试。。。。。。
     * @param args
     */
    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, IOException, InvalidKeySpecException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
//        try {
//            KeyPairData keyPairData = generateCsr(null);
//            txtToFile(keyPairData.priKey,"server.key");
//            txtToFile(keyPairData.csr,"server.csr");
//            txtToFile(keyPairData.pubKey,"server_pub.key");
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        } catch (InvalidAlgorithmParameterException e) {
//            throw new RuntimeException(e);
//        } catch (OperatorCreationException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        getPriKeyTxt();
//        getCsrTxt();

        // 获取私钥
        String priKeyTxt = getPriKeyTxt();
        String pubKeyTxt = getPubKeyTxt();
        String s = encryptData("shouzhi", priKeyTxt);
        String p = decryptData(s, pubKeyTxt);
        System.out.println(p);
    }


}