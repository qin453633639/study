package com.bestbigbird;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    private static Log commonslogger= LogFactory.getLog(App.class);
    private static Logger slf4jlogger = LoggerFactory.getLogger(App.class);
    private static StringBuilder a = new StringBuilder();
    public static void main( String[] args ) {
        System.out.println(1);
      /*  //级别为debug的日志
        slf4jlogger.debug("Hello! debug!" +slf4jlogger.getClass());
        //级别为info的日志
        slf4jlogger.info("Hello! info!"+slf4jlogger.getClass());
        //级别为warn的日志
        slf4jlogger.warn("Hello! warn!"+slf4jlogger.getClass());
        //级别为error的日志
        slf4jlogger.error("Hello! error!"+slf4jlogger.getClass());*/
        slf4jlogger.debug("Hello! debug!" +slf4jlogger.getClass());
        slf4jlogger.error("super error111!");

         String s = null;
         try{
             System.out.println(a.lastIndexOf("1"));
         }catch (Exception e){
             slf4jlogger.error("super error111! {}",e.getCause());
         }
        /*try{
            String i = " sdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffsdffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffsdffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffsdffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffsdffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffsdffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffsdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
            for(;;){
                a.append(i);
            }
        }catch (Exception e){
            System.out.println(1);
            slf4jlogger.error("sadfadsff",e);
        }*/
    }
}
