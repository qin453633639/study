package com.bestbigbird.echoDemo.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 标示一个 ChannelHandler 可以被多个 Channel 安全地共享
 */
@ChannelHandler.Sharable
public class EchoServerHandler1 extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
       /* System.out.println(
                "Server received1: " + in.toString(CharsetUtil.UTF_8));*/
        //将接收到的消息 写给发送者，而不冲刷出站消息
       // ctx.channel().write(msg);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("----------------------------------EchoServerHandler1 channelActive-----------------------------------------");
        super.channelActive(ctx);

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("----------------------------------EchoServerHandler1 handlerAdded-----------------------------------------");
        super.handlerAdded(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("----------------------------------EchoServerHandler1 channelRegistered-----------------------------------------");
        super.channelRegistered(ctx);
    }
}