package com.example.springbootproject.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    /**
     * 对字符串进行MD5加密
     * @param str 待加密字符串
     * @return 加密后的字符串
     */
    public static String encrypt(String str){
        try{
            // 创建MessageDigest实例并指定算法
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 将字符串转换为字节数组
            byte[] bytes = str.getBytes();
            // 更新摘要信息
            md.update(bytes);
            // 获取摘要信息并转换为十六进制字符串
            byte[] mdBytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(byte b: mdBytes){
                sb.append(Integer.toHexString((b & 0xFF)|0x100).substring(1,3));
            }
            return sb.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 验证字符串是否匹配加密后的值
     * @param str 待验证字符串
     * @param encryptedStr 加密后的字符串
     * @return 是否匹配
     */
    public static boolean verify(String str,String encryptedStr){
        return encrypt(str).equals(encryptedStr);
    }
}
