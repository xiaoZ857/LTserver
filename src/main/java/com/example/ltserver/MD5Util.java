package com.example.ltserver;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static byte[] encode2bytes(String source) {
    byte[] result = null;
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.reset();
        md.update(source.getBytes(StandardCharsets.UTF_8));
        result = md.digest();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }

    return result;
}


    public static String encode2hex(String source) {
        byte[] data = encode2bytes(source);

        StringBuilder hexString = new StringBuilder();
        for (byte datum : data) {
            String hex = Integer.toHexString(0xff & datum);

            if (hex.length() == 1) {
                hexString.append('0');
            }

            hexString.append(hex);
        }

        return hexString.toString();
    }

    /**
     * 验证字符串是否匹配
     * @param unknown 待验证的字符串
     * @param okHex 使用MD5加密过的16进制字符串
     * @return 匹配返回true，不匹配返回false
     */
    public static boolean validate(String unknown , String okHex) {
        return okHex.equals(encode2hex(unknown));
    }
}
