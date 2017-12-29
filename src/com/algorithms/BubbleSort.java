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
// This sort  works like,  Adjacent elements is compared and the elements are swapped if they are not in order.
public class BubbleSort {
    public static void main(String args[]){
        int a[] = {7, 5, 2, 4, 3, 1, 19, 0, 12, 18, 59, 18, 14, 79, 41, 11,34,89,21,16,69,13,51,79,45,23,27,33,63,91,96,89,82,76,7, 5, 2, 4, 3, 1, 19, 0, 12, 18, 59, 18, 14, 79, 41, 11,34,89,21,16,69,13,51,79,45,23,27,33,63,91,96,89,82,76,7, 5, 2, 4, 3, 1, 19, 0, 12, 18, 59, 18, 14, 79, 41, 11,34,89,21,16,69,13,51,79,45,23,27,33,63,91,96,89,82,76,7, 5, 2, 4, 3, 1, 19, 0, 12, 18, 59, 18, 14, 79, 41, 11,34,89,21,16,69,13,51,79,45,23,27,33,63,91,96,89,82,76,7, 5, 2, 4, 3, 1, 19, 0, 12, 18, 59, 18, 14, 79, 41, 11,34,89,21,16,69,13,51,79,45,23,27,33,63,91,96,89,82,76,7, 5, 2, 4, 3, 1, 19, 0, 12, 18, 59, 18, 14, 79, 41, 11,34,89,21,16,69,13,51,79,45,23,27,33,63,91,96,89,82,76};
        int n = a.length;
        System.out.println("size: "+n);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a[j] >= a[j + 1]) {
                    // swap minIndex with I value
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("time taken "+(endTime-startTime));
        for (int b : a) {
        System.out.print(b+", ");
        }
    }
   
}
