package com.msg.senders.proxys;

import com.msg.senders.Sender;


public class SenderProxy implements Sender
{
    private Sender sender;


    public SenderProxy(Sender sender) {
        this.sender = sender;
    }

    @Override
    public void sendBefore(Object... sources) {
        sender.sendBefore(sources);
    }

    @Override
    public void send(Object... sources) {
        sendBefore(sources);
        sender.send(sources);
        sendAfter(sources);
    }

    @Override
    public void sendAfter(Object... sources) {
        sender.sendAfter(sources);
    }
}
