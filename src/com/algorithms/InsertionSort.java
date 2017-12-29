/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms;

/**
 *
 * @author nagendrababu.g
 */
// This sort  can be done with single element choosen and takes its index and look for Min Index 
public class InsertionSort {
    public static void main(String args[]){
        int a[] = {7, 5, 2, 4, 3, 1};
        int n = a.length;   
        
        for (int i = 0; i < n; i++) {
            int j = i-1;
            int key = a[i];
            while( j>-1 &&  a[j] > key){
                a[j+1] =  a[j];
                j--;
            }
            a[j+1] = key;
        }
        
        for (int b : a) {
        System.out.print(b);
        }
    }
   
}
