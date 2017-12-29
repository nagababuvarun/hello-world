///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.algorithms;
//
//import com.imimobile.stataggregator.jmlogserver.JMLogger;
//import com.imimobile.stataggregator.jmlogserver.ProcessConstants;
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import org.json.JSONException;
//import org.json.JSONObject;
//
///**
// *
// * @author nagendrababu.g
// */
//public class QuickSort {
//    public static void main(String args[]) throws IOException, JSONException{
//        System.out.println("start ****************************** start");
//        String test = "{\n" +
//"  \"to\": \"APA91bFzZEvlrbAeNOyPAilRclj_KtHDczhy8BsrK4ZoDqFxi4Rn44oYNqhIg-pYRus0oXpaPhXjesEKiuW4cTOSQOmJls4VnAwqmvnw82Tlu0GQ78UZoxqob5RmxH9bgz0xNAaCWmNfujbAZytAX-tb_9UzcZgdBA\",\n" +
//"  \"data\": {\n" +
//"    \"hello\": \"This is a Firebase Cloud Messaging Device Group Message Nag !\"\n" +
//"   }\n" +
//"}";
//        String m_fcmURL = "https://fcm.googleapis.com/fcm/send";
//        JSONObject json = new JSONObject(test);
//        String apikey = "AAAAHfJ8aeU:APA91bGOl0r0a5zRTDj3Nba8g8TGlrF2WuZWyJkowMRnT55FcVz42m2kviBkn3nivWsXAK82ONbESPfhBme16nfpfUn4aI60UpNZ7DJqgRdvVGi2BVoddjpwiipZV9_MVVGU5GcNpoVW";
//         URL obj = new URL(m_fcmURL);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//        con.setRequestMethod("POST");
//        con.setRequestProperty("Authorization", "key=" + apikey + "");
//        con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//        con.setDoOutput(true);
//
//        String body = json.toString();
//        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//        wr.writeBytes(body);
//        wr.flush();
//        wr.close();
//
//        int responseCode = con.getResponseCode();
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            System.out.println("response : "+response);
//
//    }
//}
//
