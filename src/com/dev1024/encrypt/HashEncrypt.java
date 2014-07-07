package com.dev1024.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class HashEncrypt {

    public enum CryptType {
        MD5, SHA1, SHA256
    };

    public static final String ALG_MD5 = "MD5";
    public static final String ALG_SHA1 = "SHA-1";
    public static final String ALG_SHA256 = "SHA-256";

    public static String encode(CryptType type, String content) {
        MessageDigest instance = null;
        byte[] encryptMsg = null;
        try {
            if (CryptType.MD5 == type) {
                instance = MessageDigest.getInstance(ALG_MD5);
            } else if (CryptType.SHA1 == type) {
                instance = MessageDigest.getInstance(ALG_SHA1);
            } else if (CryptType.SHA256 == type) {
                instance = MessageDigest.getInstance(ALG_SHA256);
            }
            encryptMsg = instance.digest(content.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(
                    "Unbelievabl! How can u bypass the method ? No such algorithm !");
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < encryptMsg.length; i++) {
            switch (Integer.toHexString(encryptMsg[i]).length()) {
                case 1:
                    buffer.append("0");
                    buffer.append(Integer.toHexString(encryptMsg[i]));
                    break;
                case 2:
                    buffer.append(Integer.toHexString(encryptMsg[i]));
                    break;
                case 8:
                    buffer.append((Integer.toHexString(encryptMsg[i])).substring(6, 8));
                    break;
            }
        }
        return buffer.toString();
    }
}
