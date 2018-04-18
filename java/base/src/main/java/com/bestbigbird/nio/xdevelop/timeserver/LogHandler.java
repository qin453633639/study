package com.bestbigbird.nio.xdevelop.timeserver;

import com.bestbigbird.nio.xdevelop.nioserver.Request;
import com.bestbigbird.nio.xdevelop.nioserver.event.EventAdapter;

import java.util.Date;

/**
 * 日志记录
 */
public class LogHandler extends EventAdapter {
    public LogHandler() {
    }

    public void onClosed(Request request) throws Exception {
        String log = new Date().toString() + " from " + request.getAddress().toString();
        System.out.println(log);
    }

    public void onError(String error) {
        System.out.println("Error: " + error);
    }
}
