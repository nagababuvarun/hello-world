/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication.high.programs;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author nagendrababu.g
 */
public class ReadHTMLTemplate {
    public static void main(String[] args) {
    File fFile = new File("D://delete/template.html");
       String html_trimmed="";
       Scanner scanner = null;
    try {
    scanner = new Scanner(new FileReader(fFile));
      while ( scanner.hasNextLine() ){
        String s=scanner.nextLine();
        //System.out.println(s);
        String tmp= s.trim();
        html_trimmed= html_trimmed.concat(tmp);
      }
        System.out.println("html_trimmed "+html_trimmed);
    }catch(Exception e){
    e.printStackTrace();
}
    finally {         
      scanner.close();
    }
}
}
