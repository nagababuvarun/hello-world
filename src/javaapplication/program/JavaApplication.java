///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package javaapplication.program;
//
//import java.io.FileInputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.Map;
//import java.util.Properties;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
///**
// *
// * @author nagendrababu.g
// */
//public class JavaApplication {
//    public static void main1(String[] args) {
//        Map<String,Integer> map=null ;
//  try  
//  {
//      FileInputStream fis = new FileInputStream("D:\\delete\\transInfoCache.ser");
//      ObjectInputStream ois = new ObjectInputStream(fis);
//      map = (Map<String,Integer>)ois.readObject();
//      System.out.println("map size "+map.size());
//      for (String key : map.keySet()) {
//          System.out.println(key+"  "+map.get(key));
//      }
//   
//  } 
//  catch (Exception e)
//   { e.printStackTrace(); }
// }
//    
//    public static void main6(String args[]) throws Exception{
//        System.out.println("start");
//        test();
//        System.out.println("end");
//    }
//    
//    public static void test(){
//     Properties props = new Properties();
//        FileInputStream fin = null;
//        try {
//            fin = new FileInputStream("E:\\Non-Netbeans//usr//usr.properties");
//            props.load(fin);
//        } catch (Exception ex) {
//            System.out.println("loadProperties() Failed. Ex : " + ex.getMessage());
//        } finally {
//            try {
//                fin.close();
//            } catch (Exception e) {
//            }
//        }
//    }
//    
//    private synchronized static void getConnection() throws Exception{
//        long m_nSleepForRetryConnection = 100;
//        long m_nConnectorWaitTimeout = 3000;
//        long lstart = System.currentTimeMillis();
//        while(true){
//            try {
//                Thread.sleep(m_nSleepForRetryConnection);
//            } catch (Exception e) {
//            }
//            long timeDiff = System.currentTimeMillis() - lstart;
//            System.out.println("Time : "+timeDiff);
//            if(timeDiff>m_nConnectorWaitTimeout){
//                System.out.println("USR connection timeout");
//                break;
//            }
//        }
//        
//    }
//    
//    
//    private synchronized static void getConnection2() throws Exception{
//        long m_nSleepForRetryConnection = 100;
//        long m_nConnectorWaitTimeout = 3000;
//        long lstart = System.currentTimeMillis();
//        long total =lstart+m_nConnectorWaitTimeout;;
//        while(true){
//            try {
//                Thread.sleep(m_nSleepForRetryConnection);
//            } catch (Exception e) {
//            }
//            if(System.currentTimeMillis()>total){
//                System.out.println("USR connection timeout");
//                break;
//            }
//            System.out.println("Time : "+(System.currentTimeMillis()-lstart));
//        }
//    }
//    
//    public static void main12(String args[]) throws JSONException{
//        String clientId = "[\"test\",\"test2\"]";
//        String appId ="1234";
//        String userId ="3455";
//        String deviceId ="255";
//        String profileInputReq = "{\"ProfileName\":\"" + appId + "\",\"SYNC\":\"1\",\"IncludeHeaders\":1,\"Query_Criteria\":[{\"AttributeName\":\"userId\",\"Relop\":\"equals\",\"Val\":\"" + userId + "\",\"Logicalop\":\"and\"},{\"AttributeName\":\"deviceId\",\"Relop\":\"equals\",\"Val\":\"" + deviceId + "\",\"Logicalop\":\"and\"}],\"SelectFields\":[{\"AttributeName\":\"pushId\"},{\"AttributeName\":\"os\"}],\"ShowInwardLinks\":\"0\",\"SelectInwardLinkFields\":[],\"ShowOutwardLinks\":\"1\",\"SelectOutwardLinkFields\":[],\"ShowAllMasterFields\":\"1\"}";
////        String test = "{\"ShowOutwardLinks\" : \"1\",\"IncludeHeaders\" : 1,\"SelectFields\" : [{\"AttributeName\" : \"pushId\"}, {\"AttributeName\" : \"os\"}, {\"AttributeName\" : \"deviceId\"}],\"ShowInwardLinks\" : \"0\",\"ProfileName\" : \"\",\"Query_Criteria\" : [{\"Val\" : \"321\",\"Logicalop\" : \"and\",\"Relop\" : \"equals\",\"AttributeName\" : \"userId\"},{\"Val\" : \"7878797\",\"Logicalop\" : \"and\",\"Relop\" : \"equals\",\"AttributeName\" : \"deviceId\"}],\"SelectInwardLinkFields\" : [],\"SYNC\" : \"1\",\"ShowAllMasterFields\" : \"1\",\"SelectOutwardLinkFields\" : []}";
//        JSONObject json = new JSONObject(profileInputReq);
//        System.out.println(json);
//        
//    }
//    
//    public static void main(String args[]) throws JSONException{
//        int arr[] = {10,20,15,24,22,9,45};
//        int i=0-1;
//        int temp = arr[i];
//        
//        arr[0] = arr[3];
//        System.out.println("start "+arr[0]);
//    }
//}
