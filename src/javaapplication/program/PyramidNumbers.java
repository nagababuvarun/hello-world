/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication.program;

public class PyramidNumbers {
    public static void main(String args[]){
        System.out.println("start");
       int num = 100;
            int i=1;
            while(i<num){
            if(i%2!=0){
                    for(int j=1;j<=i;j++){
                      System.out.print(j);
                    }
                    System.out.print("\n");
            }
            i++;
            }
            System.out.println("end");
    }
}
