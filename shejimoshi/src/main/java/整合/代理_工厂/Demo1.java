package 整合.代理_工厂;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Auther : ChenZhongChuang
 * @Date : 2019/9/7 17:03
 * @Descoription :
 */
public class Demo1 {
    public static void main(String[] args){

    }

    interface Pay{
        void pay();
    }
    class HeliPay implements Pay{
        @Override
        public void pay(){
            System.out.println("合利宝支付");
        }
    }
    class YeBaoPay implements Pay{
        @Override
        public void pay(){
            System.out.println("易宝支付");
        }
    }
}
