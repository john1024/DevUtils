package com.dev1024.encrypt;

import com.dev1024.encrypt.HashEncrypt.CryptType;


public class Test {

    public static void main(String[] args) {

        String value = "123456";

        System.out.println("SHA1");
        System.out.println(HashEncrypt.encode(CryptType.SHA1, value));

        System.out.println("Md5");
        System.out.println(Md5.encode(value));

        System.out.println("RSA");
        String rsaValue = Rsa.encryptByPublicKey(value, Keys.PUBLIC);
        System.out.println(rsaValue);

        System.out.println("RSA");
        System.out.println(Rsa.decryptByPrivatekey(rsaValue, Keys.PRIVATE));

    }
}
