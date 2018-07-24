package com.bestbigbird.echoDemo.memory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;

public class Test {
    public static void main(String[] args) {

        PooledByteBufAllocator pooledByteBufAllocator = new PooledByteBufAllocator(false);
        ByteBuf buf1 = pooledByteBufAllocator.buffer(1024*1024*2);
        ByteBuf buf2 = pooledByteBufAllocator.buffer(1024*1024*2);
        ByteBuf buf3 = pooledByteBufAllocator.buffer(1024*1024*2);
    }
}
