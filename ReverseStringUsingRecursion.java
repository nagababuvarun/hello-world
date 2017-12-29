package javaapplication.program;


public class ReverseStringUsingRecursion {
    public static void main(String args[]){
        String str = "helloworld";
       String reverse =  reverseString(str);
        System.out.println("reverse is "+reverse);
    }
    static String rev ="";
    public static String reverseString(String str){
        if (str.length() > 0) {
        rev+= str.charAt(str.length()-1);
        reverseString(str.substring(0,str.length()-1));
        }
        return rev;
    }
}
