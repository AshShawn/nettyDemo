package com.shenqi.test.EchoServer;/**
 * Create by sq598 on 2019/5/24
 */

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @program: nettyDemo
 * @description:
 * @author: 沈琪
 * @create: 2019-05-24 13:53
 **/
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {   //指定类型 调用完channelread0时释放资源,
                                                                                // 而ChannelInboundHandlerAdapter在readcomplete后 调用writeandFlush释放
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!",
                CharsetUtil.UTF_8));
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) {
        System.out.println(
                "Client received: " + in.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
