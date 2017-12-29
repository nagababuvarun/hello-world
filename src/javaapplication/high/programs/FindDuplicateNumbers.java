package javaapplication.high.programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindDuplicateNumbers {
    public static void main(String args[]){
        int num[] = {10,20,15,48,15,46,49,20,15};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            if(map.containsKey(num[i]))
                map.put(num[i], map.get(num[i])+1);
            else
                map.put(num[i], 1);
        }
        Set<Integer> set = map.keySet();
        for(Integer key :set){
            if(map.get(key)>1){
                System.out.println("duplicate number is "+key+" times "+map.get(key));
            }
        }
        
        findDuplicateNumberWithoutCollection();
    }
    
    public static void findDuplicateNumberWithoutCollection(){
        int num[] = {10,20,15,48,15,46,49,20,15};
        String revStr ="";
        String numStr="";
        for (int i = 0; i < num.length; i++) {
            if(numStr.contains(num[i]+"")){
                System.out.println(num[i]);
                revStr += num[i]+",";
            }else{
                numStr += num[i]+",";
            }
          }
        System.out.println("num "+numStr);
        System.out.println("rev "+revStr);
    }
    
    
    
    
}
