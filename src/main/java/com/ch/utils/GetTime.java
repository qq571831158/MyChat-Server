package com.ch.utils;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Created by apple on 2017/3/11.
 */
public class GetTime {
    public static Timestamp getTimeStamp(){
        Date date = new Date();
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        return Timestamp.valueOf(nowTime);
    }
}
