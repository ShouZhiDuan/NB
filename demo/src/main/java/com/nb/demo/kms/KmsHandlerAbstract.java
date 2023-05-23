package com.nb.demo.kms;

/**
 * @author shouzhi@duan
 * 多态算法
 */
public interface KmsHandlerAbstract {

    /**
     * 生成 DEK
     * @return
     */
    String generateDEK();

    /**
     * 生成 CMK
     * @return
     */
    String generateCMK();

    /**
     * 加密 DEK
     * @return
     */
    String encryptDEK();

    /**
     * 解密 DEK
     * @return
     */
    String decryptDEK();

    /**
     * 加密 CMK
     * @return
     */
    String encryptCMK();

    /**
     * 解密 CMK
     * @return
     */
    String decryptCMK();
}