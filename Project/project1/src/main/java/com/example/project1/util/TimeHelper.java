package com.example.project1.util;

import java.util.Calendar;
import java.util.Date;

public class TimeHelper {
    private TimeHelper(){}
    private static class InnerInstanceClazz {
        private static final TimeHelper instance = new TimeHelper();
    }
    public static TimeHelper getInstance(){
        return InnerInstanceClazz.instance;
    }
    private Calendar c = Calendar.getInstance();
    public Date changeDayOnly(Date date, int num){
        c.setTime(date);
        c.add(Calendar.DATE,num);
        c.set( Calendar.HOUR_OF_DAY, 0 );
        c.set( Calendar.MINUTE, 0 );
        c.set( Calendar.SECOND, 0 );
        c.set( Calendar.MILLISECOND, 0 );
        return c.getTime();
    }
}