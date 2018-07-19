package com.bestbigbird.echoDemo.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
@ChannelHandler.Sharable
public class EchoServerOutHandler2 extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("EchoServerOutHandler2  write" + msg);
        ctx.writeAndFlush(msg);
    }

    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
        System.out.println("EchoServerOutHandler2.flush");
        ctx.flush();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("----------------------------------EchoServerOutHandler2 handlerAdded-----------------------------------------");
        super.handlerAdded(ctx);
    }
}