/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.statistics;

/**
 *
 * @author nagendrababu.g
 */
public class FindMean {

    public static void main(String[] args) {
//       String sample = "1, 10, 15, 16, 25, 32, 40, 50, 65, 70, 75, 100";
//        String sample = "10, 20, 30, 40, 50, 60";
        String sample = "35, 45, 30, 35, 40, 25";
        
        System.out.println("squre : "+Math.sqrt(125));
        String arr[] = sample.replaceAll(" ", "").split(",");
        int n = arr.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total = total + Integer.parseInt(arr[i].trim());
        }
        double mean = total / n;
        System.out.println("mean " + mean);
        System.out.println("variance " + findVariance(mean, arr));
        System.out.println("deviation " + standarddeviation(mean, arr));
    }

    public static double findVariance(double mean, String[] arr) {
        double varinace = 0.0;
        double totalVal = 0.0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            totalVal += (Integer.parseInt(arr[i].trim()) - mean) * (Integer.parseInt(arr[i].trim()) - mean);
        }
        varinace = totalVal / n;
        return varinace;
    }

    public static double standarddeviation(double mean, String[] arr) {
        double variance = 0.0;
        double totalVal = 0.0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            totalVal += (Integer.parseInt(arr[i].trim()) - mean) * (Integer.parseInt(arr[i].trim()) - mean);
        }
       variance = totalVal / n;
        
        return Math.sqrt(variance);
    }
}
