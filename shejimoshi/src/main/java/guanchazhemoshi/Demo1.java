package guanchazhemoshi;

import java.util.Observable;
import java.util.Observer;

/**
 * 简单基础版
 * @Auther : ChenZhongChuang
 * @Date : 2019/9/8 9:34
 * @Descoription :
 */
public class Demo1 {
    public static void main(String[] args){
        TestObservable testObservable = new TestObservable();
        testObservable.less(1);
        System.out.println(">>>>>>第一轮调价结束》");
        testObservable.more(1);
    }

    static class TestObservable extends Observable implements Observer{
        public TestObservable() {
            super();
            addObserver(this);
        }

        void more(int i){
            System.out.println("涨价》》》"+i);
            update(i);
        }
        void less(int i){
            System.out.println("降价》》》"+i);
            update(-i);
        }
        void update (int i){
            System.out.println("加个变动》》》"+i);
            setChanged();
            notifyObservers(i);
        }
        @Override
        public void update(Observable o, Object arg) {
            Integer i = (Integer) arg;
            System.out.println(">>>>>>>>>>>>>>>价格变动"+arg);
            if(i>0){
                System.out.println("产量增加，购买量减少");
            }else if(i<0){
                System.out.println("产量减少，购买量增多");
            }
        }
    }
}
