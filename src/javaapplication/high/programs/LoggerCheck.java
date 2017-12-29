/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication.high.programs;

import java.io.File;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.RollingFileAppender;

/**
 *
 * @author nagendrababu.g
 */
public class LoggerCheck {

    final static Logger logger = Logger.getLogger(LoggerCheck.class);
//    public static void main(String[] args) {
//        String test = "D://delete/loggertest/log4j-test.txt";
//        int path = test.lastIndexOf("/");
//        System.out.println("path : " +test.substring(0, test.lastIndexOf("/")));
//    }
    public static void main(String[] args) {
        try {
            String msgkb = "{\"status_code\":0,\"service_id\":\"4\",\"session_id\":-1,\"origin\":\"9440\",\"actual_msg\":\"05000302\",\"appid\":\"4\",\"submit_date\":\"2014-06-1713:28:12.012\",\"corelation_id\":\"14029968292758722\",\"destination\":\"9563520528\",\"dlvr_referenceid\":\"02422DEE70\",\"requested\":2,\"report_date\":\"2014-06-1713:28:12.012\",\"err_code\":0,\"trans_id\":\"tid_14029968292758726\",\"dcs\":0,\"msg_id\":\"02422DEE70\",\"report\":\"S\",\"extraparams\":\"seg_count%3D3%26channel_version%3D0%26x_ascii2gsm%3D1%26x_wqfull%3D30%26calendarname%3D13966317400060%26group_by_header%3D10001%2BROW%26x_charset%3D2%26dton%3D1%26campaignid%3DSMS_13966318000061%26x_channel%3D1%26campaignname%3DAio%2BProtect%2BBasic%2BROW%26x_servicename%3D4%26x_ngmpmtype%3D2%26x_ccode%3D1%26is_reminder%3D0%26x_udhi%3D1%26esmeid%3D-1%26ston%3D0%26deploy_date%3D2014-06-17%2B13%253A27%253A59%26x_appid%3D4%26x_msgpersec%3D4%26x_fragment%3D2%26campaigngroup%3D13953437990096%26x_drref%3D1%26x_wthrottle%3D15000%26x_tfragment%3D3%26x_validity%3D60%26dnpi%3D1%26translation_plan%3D301\",\"r_esmeid\":10,\"esme_id\":10}";
            String msg512 = "{\"status_code\":0,\"service_id\":\"4\",\"session_id\":-1,\"origin\":\"9440\",\"actual_msg\":\"05000302\",\"appid\":\"4\",\"submit_date\":\"2014-06-1713:28:12.012\",\"corelation_id\":\"14029968292758722\",\"destination\":\"9563520528\",\"dlvr_referenceid\":\"02422DEE70\",\"requested\":2,\"report_date\":\"2014-06-1713:28:12.012\",\"err_code\":0,\"trans_id\":\"tid_14029968292758726\",\"dcs\":0,\"msg_id\":\"02422DEE70\",\"report\":\"S\",\"extraparams\":\"seg_count%3D3%26channel_version%3D0%26x_ascii2gsm%3D1%26x_wqfull%3nameOW%26x_charset%3D\",\"r_esmeid\":10,\"esme_id\":10}";
            String msg210 = "{\"status_code\":0,\"service_id\":\"4\",\"session_id\":-1,\"origin\":\"9440\",\"actual_msg\":\"05000302\",\"appid\":\"4\",\"submit_date\":\"2014-06-1713:28:12.012\",\"corelation_id\":\"14029968292758722\",\"destination\":\"9563520528\",\"dlvr_referenceid\":\"02422DEE70\",\"requested\":2}";
            for (int i = 0; i < 15; i++) {
                logger.debug(msg210);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("exception");
        }
    }
}
