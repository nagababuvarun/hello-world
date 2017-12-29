/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inheritence;

/**
 *
 * @author nagendrababu.g
 */
public class BaseInheritance {
    public static void main(String[] args) {
        Parent p = new Parent();
        int i = p.getI();
        System.out.println("repsone  : "+i);
        
        Child c = new Child();
        int j = c.getI();
        System.out.println("repsone2  : "+j);
        
        Parent pc = new Child();
        int k = pc.getI();
        System.out.println("repsone2  : "+k);
    }
   
}

 class Parent{
    int i = 10;
    protected int getI(){
        System.out.println("[Parent getI] called ");
        return this.i;
    }
}


class Child extends Parent{
    int i=20;
    protected int getI(){
        System.out.println("[Child getI] called ");
        return this.i;
    }
    protected int getJ(){
        System.out.println("[Child getI] called ");
        return this.i;
    }
}