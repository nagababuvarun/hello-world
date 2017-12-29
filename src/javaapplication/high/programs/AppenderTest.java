/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication.high.programs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.log4j.RollingFileAppender;
import sun.misc.BASE64Encoder;

/**
 *
 * @author nagendrababu.g
 */

public class AppenderTest extends RollingFileAppender {
  private static final String ALGO = "AES";
    private static Cipher c;

    static {
        try {
            c = Cipher.getInstance(ALGO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rollOver() {
        String file = super.getFile();
        String modifiedFile = encryptFileLogs(file);
        super.setFile(modifiedFile);
        System.out.println("Rollver called : "+modifiedFile);
        super.rollOver();
    }
    String secretKey = "imimobile@123456";
    public String encryptFileLogs(String fileName) {
        File file = new File(fileName);
        String filePath = fileName.substring(0, fileName.lastIndexOf("/"));
        String destFile = filePath+"/"+System.currentTimeMillis()+".txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        if (file.exists()) {
            try {
                br = new BufferedReader(new FileReader(fileName));
                bw = new BufferedWriter(new FileWriter(destFile));
                String line;
                while ((line = br.readLine()) != null) {
                    try {
//                        line = encrypt(line, EncryptLog.getInstance().getSecretKey());
                        line = encrypt(line, secretKey);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    bw.write(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                    bw.flush();
                    bw.close();
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.out.println("Exception raised while closing files " + ex);
                }
            }
        } else {
            System.out.println("File Not exist in Location");
        }
        file.delete();
        File destfile = new File(destFile);
        destfile.renameTo(new File(fileName));
        return destFile;
    }
    
    
    public static String encrypt(String data, String strKey) throws Exception {
        if (data == null || strKey.isEmpty()) {
            return data;
        }
        Key key = generateKey(strKey);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        return new BASE64Encoder().encode(encVal);
    }
    
    private static Key generateKey(String strKey) throws Exception {
        return new SecretKeySpec(strKey.getBytes(), ALGO);
    }

}
