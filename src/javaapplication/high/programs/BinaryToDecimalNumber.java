package javaapplication.high.programs;

public class BinaryToDecimalNumber {
    public static void main(String args[]){
        int binary[] = {1,0,1,0,0,1};
        int decimal = 0;
        for (int i = 0; i < binary.length; i++) {
              decimal += binary[i]*calcPower(binary.length-1-i);
        }
        System.out.println("decimal "+decimal);
        
    }
    public static int calcPower(int power){
        int pwval = 1;
        for (int i = 0; i < power; i++) {
            pwval = pwval*2;
        }
        return pwval;
    }
}
