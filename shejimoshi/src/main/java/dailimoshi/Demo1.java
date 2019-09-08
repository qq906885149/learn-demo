package dailimoshi;

/**
 * @Auther : ChenZhongChuang
 * @Date : 2019/9/7 14:02
 * @Descoription :
 */
public class Demo1 {
    public static void main(String[] args){
        MyMsgSendProxy myMsgSendProxy = new MyMsgSendProxy(new MyMsgSend());
        myMsgSendProxy.sendMsg();
    }

    static interface MsgSend{
        void sendMsg();
    }

    static class MyMsgSend implements MsgSend{

        @Override
        public void sendMsg() {
            System.out.println("send msg !!!");
        }
    }

    static class MyMsgSendProxy implements MsgSend{
        private MyMsgSend myMsgSend;

        public MyMsgSendProxy(MyMsgSend myMsgSend) {
            this.myMsgSend = myMsgSend;
        }

        @Override
        public void sendMsg() {
            beforeSend();
            myMsgSend.sendMsg();
            afterSend();
        }

        private void afterSend() {
            System.out.println("发送后,插入发送日志");
        }

        private void beforeSend() {
            System.out.println("发送前，检查风控费用，扣除风控费用");
        }
    }
}
