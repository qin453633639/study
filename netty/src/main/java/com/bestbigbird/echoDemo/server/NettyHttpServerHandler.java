package com.bestbigbird.echoDemo.server;


import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.multipart.MemoryAttribute;
import io.netty.util.CharsetUtil;
import static io.netty.buffer.Unpooled.copiedBuffer;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qinwei on 2019/8/3.
 */
public class NettyHttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) {
        System.out.println(fullHttpRequest);
        String responseContent;
        HttpResponseStatus responseStatus = HttpResponseStatus.OK;
        if (fullHttpRequest.method() == HttpMethod.GET) {
            System.out.println(getGetParamasFromChannel(fullHttpRequest));
            responseContent = "GET method over";
        } else if (fullHttpRequest.method() == HttpMethod.POST) {
            System.out.println(getPostParamsFromChannel(fullHttpRequest));
            responseContent = "POST method data";
        } else {
            responseStatus = HttpResponseStatus.INTERNAL_SERVER_ERROR;
            responseContent = "INTERNAL_SERVER_ERROR";
        }
        FullHttpResponse response = responseHandler(responseStatus, responseContent);
        channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    private Map<String, Object> getGetParamasFromChannel(FullHttpRequest fullHttpRequest) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (fullHttpRequest.method() == HttpMethod.GET) {
            QueryStringDecoder decoder = new QueryStringDecoder(fullHttpRequest.uri());
            Map<String, List<String>> paramList = decoder.parameters();
            for (Map.Entry<String, List<String>> entry : paramList.entrySet()) {
                params.put(entry.getKey(), entry.getValue().get(0));
            }
            return params;
        } else {
            return null;
        }
    }

    private Map<String, Object> getPostParamsFromChannel(FullHttpRequest fullHttpRequest) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (fullHttpRequest.method() == HttpMethod.POST) {
            String strContentType = fullHttpRequest.headers().get("Content-type").trim();
//            if (strContentType.contains("x-www-form-urlencoded")) {
            if (strContentType.contains("form")) {
                params = getFormParams(fullHttpRequest);
            } else if (strContentType.contains("application/json")) {
                try {
                    params = getJSONParams(fullHttpRequest);
                } catch (UnsupportedEncodingException e) {
                    return null;
                }
            } else {
                return null;
            }
            return params;
        }
        return null;
    }

    private Map<String, Object> getFormParams(FullHttpRequest fullHttpRequest) {
        Map<String, Object> params = new HashMap<String, Object>();
        // HttpPostMultipartRequestDecoder
        HttpPostRequestDecoder decoder = new HttpPostRequestDecoder(new DefaultHttpDataFactory(false), fullHttpRequest);
        List<InterfaceHttpData> postData = decoder.getBodyHttpDatas();
        for (InterfaceHttpData data : postData) {
            if (data.getHttpDataType() == InterfaceHttpData.HttpDataType.Attribute) {
                MemoryAttribute attribute = (MemoryAttribute) data;
                params.put(attribute.getName(), attribute.getValue());
            }
        }
        return params;
    }

    private Map<String, Object> getJSONParams(FullHttpRequest fullHttpRequest) throws UnsupportedEncodingException {
        Map<String, Object> params = new HashMap<String, Object>();
        ByteBuf content = fullHttpRequest.content();
        byte[] reqContent = new byte[content.readableBytes()];
        content.readBytes(reqContent);
        String strContent = new String(reqContent, "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(strContent);
        for (String key : jsonObject.keySet()) {
            params.put(key, jsonObject.get(key));
        }
        return params;
    }

    private FullHttpResponse responseHandler(HttpResponseStatus status, String responseContent) {
        ByteBuf content = copiedBuffer(responseContent, CharsetUtil.UTF_8);
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, status, content);
        response.headers().set("Content-Type", "text/plain;charset=UTF-8;");
        response.headers().set("Content-Length", response.content().readableBytes());
        return response;
    }
}
