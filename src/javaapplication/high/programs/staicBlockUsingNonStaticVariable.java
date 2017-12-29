package javaapplication.high.programs;
public class staicBlockUsingNonStaticVariable {
    
   static int x = 10;
    public void init(){
        staicBlockUsingNonStaticVariable.x=20;
    }
    public static void main(String args[]){
        staicBlockUsingNonStaticVariable st = new staicBlockUsingNonStaticVariable();
        st.init();
        System.out.println("before static x is : "+staicBlockUsingNonStaticVariable.x);
        staicBlockUsingNonStaticVariable.x=30;
        Test test =new Test();
        System.out.println("before calling sample method");
        test.sample();
        
        Test test2 =new Test();
        test2.sample();
        
        System.out.println("after calling sample ");
    }
            
}


class Test{
    static{
        System.out.println("test started");
//        staicBlockUsingNonStaticVariable test = new staicBlockUsingNonStaticVariable();
        System.out.println("x value is : "+staicBlockUsingNonStaticVariable.x);
        System.out.println("ends");
    }
    public void sample(){
        System.out.println("sample method of test");
    }
}