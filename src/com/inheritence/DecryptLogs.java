package com.inheritence;


import java.security.Key;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nagendrababu.g
 */
public class DecryptLogs {
    private static final String ALGO = "AES";
    private static String IMI_SECRET_KEY = "imimobile@123456";
    private static String IMI_ENC_SECRET_KEY = "qvwWjKCKxvH5IGqI3knsZqeCdU6vA2Kh1DZD4Op6BYM=";
     private static String encryptedData = "61vn/B1XneVgOZd1bOJKmkumS/o6Qlld+5C3Ig23mSQ=";


    public static void main(String[] args) throws Exception {
        System.out.println("start");
        String decrpytKey = decrypt(IMI_ENC_SECRET_KEY,IMI_SECRET_KEY);
        System.out.println(decrpytKey);
        System.out.println(decrypt(encryptedData,decrpytKey));
        System.out.println("end");
    }
    
    
    
    
    
   public static String decrypt(String encryptedData, String strKey){
        try {
            Key key = generateKey(strKey);
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.DECRYPT_MODE, key);
           byte[] decordedValue  = com.sun.org.apache.xml.internal.security.utils.Base64.decode(encryptedData);
//            byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
            byte[] decValue = c.doFinal(decordedValue);
            String decryptedValue = new String(decValue);
            return decryptedValue;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedData;
    }
     private static Key generateKey(String strKey) throws Exception {
        Key key = new SecretKeySpec(Arrays.copyOf(strKey.getBytes("UTF-8"), 16), "AES");
        return key;
    }

       public static String encrypt(String Data,String strKey) {
        try {
            Key key = generateKey(strKey);
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = c.doFinal(Data.getBytes());
            String encryptedValue = new BASE64Encoder().encode(encVal);
            return encryptedValue;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Data;
    }
 
}
