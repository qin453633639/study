package com.bestbigbird.echoDemo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {
    private final int port;
    public EchoServer(int port) {
        this.port = port;
    }
    public static void main(String[] args) throws Exception {

        int port = 3600;
        new EchoServer(port).start();
    }

    public void start() throws Exception {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        final EchoServerHandler1 serverHandler1 = new EchoServerHandler1();

        final EchoServerOutHandler out = new EchoServerOutHandler();
        final EchoServerOutHandler2 out2 = new EchoServerOutHandler2();

        EventLoopGroup group = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group, work)
                    //指定所使用的 NIO 传输 Channel
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))

                    .childOption(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator())
                   // .option(ChannelOption.SO_RCVBUF,256)
                    //添加一个 EchoServerHandler 到子 Channel的 ChannelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(serverHandler).addLast(serverHandler1);
                            ch.pipeline().addLast(out2).addLast(out);
                        }
                    });

            ChannelFuture f = b.bind().sync();
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}