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
        System.out.println(
                "Server received1: " + in.toString(CharsetUtil.UTF_8));
        //将接收到的消息 写给发送者，而不冲刷出站消息
        ctx.channel().write(msg+"12313123213");
        ctx.channel().flush();
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        // 将未决消息冲刷到 远程节点，并且关闭该 Channel
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}