package com.bestbigbird.nio.xdevelop.nioserver.event;

import com.bestbigbird.nio.xdevelop.nioserver.Request;
import com.bestbigbird.nio.xdevelop.nioserver.Response;

/**
 * <p>Title: 事件适配器</p>
 * @author starboy
 * @version 1.0
 */

public abstract class EventAdapter implements ServerListener {
    public EventAdapter() {
    }
    public void onError(String error) {
    }
    public void onAccept() throws Exception {
    }
    public void onAccepted(Request request)  throws Exception {
    }
    public void onRead(Request request)  throws Exception {
    }
    public void onWrite(Request request, Response response)  throws Exception {
    }
    public void onClosed(Request request)  throws Exception{
    }
}
