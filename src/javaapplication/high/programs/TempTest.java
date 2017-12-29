/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication.high.programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author nagendrababu.g
 */
public class TempTest {

    public static void main(String args[]) throws FileNotFoundException {
        System.out.println("start");
        File file = new File("E://Backup/");

        File[] listFiles = file.listFiles();
        for (File files : listFiles) {
            if (files.isFile()) {
                FileReader fr = new FileReader(file);
                Scanner scan = new Scanner(fr);
                int num = Integer.decode("0x0a");
                char c = (char) num;
                scan.useDelimiter(c + "");
                System.out.println("file starts reading...");
                long starttime = System.currentTimeMillis();
                while (scan.hasNext()) {
                    scan.next();
                }
                long endtime = System.currentTimeMillis();
                System.out.println("time taken " + (endtime - starttime));
            }
        }
        System.out.println("end");
    }
}
