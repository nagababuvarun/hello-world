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
public class SelectionSort {
    public static void main(String args[]){
         int a[] = {7, 5, 2, 4, 3, 1,6};
         int n = a.length;
          for (int i = 0; i < n; i++) {
              int minIndex = i;
              for (int j = i; j < n; j++) {
                  if (a[j]<a[minIndex]) {
                      minIndex = j;
                  }
              }
              int temp = a[minIndex];
              a[minIndex] = a[i];
              a[i] = temp;
        }
          
          
        for (int b : a) {
        System.out.print(b+", ");
        }
    }
}
