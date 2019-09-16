package com.msg.senders;

import com.msg.senders.proxys.SenderProxy;

import java.util.Observable;
import java.util.Observer;

/**
 * @Auther : ChenZhongChuang
 * @Date : 2019/9/15 10:03 PM
 * @Descoription :
 */
public abstract class BaseSender extends Observable implements Sender,Observer{
    @Override
    public void update(Observable o, Object arg) {

    }
}
