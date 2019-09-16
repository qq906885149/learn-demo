package com.msg.senders;

/**
 * @Auther : ChenZhongChuang
 * @Date : 2019/9/15 10:00 PM
 * @Descoription :
 */
public class WxSender implements Sender{
    @Override
    public void sendBefore(Object... sources) {
        System.out.println("微信消息发送前");
    }

    @Override
    public void send(Object... sources) {
        System.out.println("微信消息发送");
    }

    @Override
    public void sendAfter(Object... sources) {
        System.out.println("微信发送消息后");
    }
}
