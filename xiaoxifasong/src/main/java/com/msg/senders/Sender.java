package com.msg.senders;

/**
 * @Auther : ChenZhongChuang
 * @Date : 2019/9/15 9:41 PM
 * @Descoription :
 */
public interface Sender {
    void sendBefore(Object... sources);
    void send(Object... sources);
    void sendAfter(Object... sources);
}
