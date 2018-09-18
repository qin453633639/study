package com.bestbigbird;


import ch.qos.logback.core.rolling.RollingFileAppender;
import org.slf4j.event.LoggingEvent;

/**
 * Created by qinwei on 2018/9/2.
 */
public class MyAppeneder extends RollingFileAppender<LoggingEvent> {

    @Override
    public void append(LoggingEvent eventObject){
        super.append(eventObject);
    }

}
