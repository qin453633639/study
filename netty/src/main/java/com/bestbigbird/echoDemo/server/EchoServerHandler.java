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
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    private int i = 0;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println(++i);
        ByteBuf in = (ByteBuf) msg;
        System.out.println( in.toString(CharsetUtil.UTF_8).length());
        System.out.println(
                "Server received: " + in.toString(CharsetUtil.UTF_8));
        //将接收到的消息 写给发送者，而不冲刷出站消息
       //ctx.write(in);
        ctx.fireChannelRead(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("----------------------------------channelActive-----------------------------------------");
        super.channelActive(ctx);

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("----------------------------------handlerAdded-----------------------------------------");
        super.handlerAdded(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("----------------------------------channelRegistered-----------------------------------------");
        super.channelRegistered(ctx);
    }
}