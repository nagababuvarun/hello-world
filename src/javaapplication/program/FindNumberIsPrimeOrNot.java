/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication.program;

/**
 *
 * @author nagendrababu.g
 */
public class FindNumberIsPrimeOrNot {
    public static void main(String args[]){
        int multipiersCOunt = 0;
        int num = 39;
        for (int i = 1; i < (num/2); i++) {
                if(num%i ==0){
                    multipiersCOunt ++;
                }
                if (multipiersCOunt > 1) {
                break;
            }
        }
        
        if (multipiersCOunt>1) 
            System.out.println("Number is not Prime..");
        else
            System.out.println("Number is Prime");
    }
}
