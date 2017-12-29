package javaapplication.high.programs;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class NosuchFileException {
    public static void main(String args[]) throws IOException, InterruptedException{
        System.out.println("start");
        File file = new File("D:/abc.txt");
        File dest = new File("D:/delete/abc.txt");
        if (file.exists()) {
            System.out.println("file exist");
            Files.move(file.toPath(),dest.toPath() ,StandardCopyOption.REPLACE_EXISTING);
            if (file.exists()) {
                System.out.println("second time");
                Files.move(file.toPath(),dest.toPath() ,StandardCopyOption.REPLACE_EXISTING);
            }
        }
        System.out.println("end");
    }
}
