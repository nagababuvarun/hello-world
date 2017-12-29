/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication.program;

import java.util.Random;

/**
 *
 * @author nagendrababu.g
 */
public class ReadFromExcel {
    public static void main(String args[]){
      String host ="10.0.2.4,10.0.10.112";
      String hosts[] = host.split(",");
        for (String host1 : hosts) {
            System.out.println(host1);
        }
    }
}
