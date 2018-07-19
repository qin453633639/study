package com.bestbigbird.echoDemo.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<String>  {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {

        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
    }
    @Override
    public void channelRead0(ChannelHandlerContext ctx, String in) {
        System.out.println("Client received: " + in);

    }
    @Override
     public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();
        //ctx.close();
    }
}