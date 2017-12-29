/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication.high.programs;


public class AddShutdownHookDemo {
    
  
  public void attachShutDownHook() {
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        System.out.println("Inside Shutdown Hook");
      }
    });
    System.out.println("Hook attached..");
  }

  public static void main(String[] args) {
    AddShutdownHookDemo sh = new AddShutdownHookDemo();
    sh.attachShutDownHook();
    for(int i=0;i<1000;i++){
        try {
            System.out.println("Last Program Line.."+i);
            Thread.sleep(100);
            if (i==200) {
                System.exit(0);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
  }
}
