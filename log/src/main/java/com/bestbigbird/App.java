package com.bestbigbird;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {
    private static Log commonslogger= LogFactory.getLog(App.class);
    private static Logger slf4jlogger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args ) {
         commonslogger.debug("i am  org.apache.commons.logging" +commonslogger.getClass());
        commonslogger.error("i am  org.apache.commons.loggingerror"+commonslogger.getClass());
        System.out.println(1);
      /*  //级别为debug的日志
        slf4jlogger.debug("Hello! debug!" +slf4jlogger.getClass());
        //级别为info的日志
        slf4jlogger.info("Hello! info!"+slf4jlogger.getClass());
        //级别为warn的日志
        slf4jlogger.warn("Hello! warn!"+slf4jlogger.getClass());
        //级别为error的日志
        slf4jlogger.error("Hello! error!"+slf4jlogger.getClass());*/
    }
}
