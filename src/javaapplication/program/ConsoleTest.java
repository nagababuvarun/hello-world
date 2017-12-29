/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication.program;

import java.io.Console;

/**
 *
 * @author nagendrababu.g
 */
public class ConsoleTest {

    public static void mainLoopBreak(String[] args) {
        loop:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 3) {
                    break loop;
                }
                System.out.println("i = " + i + " j = " + j);
            }
        }
    }
    public static void mainSwapUsingThirdVariable(String[] args) {
        int a=3;
        int b=5;
        int temp = a+b;
        a = temp-a;
        b = temp -b;
        System.out.println("a/b"+a+"/"+b);
    }
    
    public static void mainWithoutThirdVariable(String[] args) {
        int a=3;
        int b=5;
        b=(a+b)-(a=b);
        System.out.println("a/b"+a+"/"+b);
    }
    public static void main(String[] args) {
        int a=3;
        int b=5;
        a=a ^ b ^ (b = a);
        System.out.println("a/b"+a+"/"+b);
    }
    
    
    
}
