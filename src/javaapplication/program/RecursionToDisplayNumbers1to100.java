/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication.program;

public class RecursionToDisplayNumbers1to100 {
    public static void main(String args[]){
        displayNums(0);
    }
    //int num = 0;
    public static void displayNums(int num){
        if (num < 100) {
            num++;
            System.out.print(num+" ");
            displayNums(num);
        }
    }
   static int len = 0;
   static String rev = "";
    public static void reverseString(String str){
        if(str.length() !=0 ){
            rev = rev+str.split("")[str.length()-1];
        }
    }
    
}
