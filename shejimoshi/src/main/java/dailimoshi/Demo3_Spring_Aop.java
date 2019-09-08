package dailimoshi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * spring aop 原理，动态代理
 * 对有具体实现类的，通过代理处，该实现类的代理对象
 * @Auther : ChenZhongChuang
 * @Date : 2019/9/7 15:25
 * @Descoription :
 */
public class Demo3_Spring_Aop {

     static class AnimalJdkDynamicProxy implements InvocationHandler {

        /**
         *  01.我们不确定委托类是谁？委托类的类型 是Object
         *   和委托类建立关联关系
         */
        private Object target;


        /**
         * 02.给我一个委托类，我返回一个代理类对象
         */
        public Object createProxy(Object target){
            //根据传递的参数 进行对象的关联
            this.target=target;
            return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                    target.getClass().getInterfaces(), this);
        }

        /**
         *
         * @param proxy :代理对象
         * @param method ：方法名
         * @param args ： 参数列表
         * @return
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("主人在召唤"); //系统级业务   开始事务
            Object result= method.invoke(target,args);  // 主业务
            System.out.println("主人离开"); //系统级业务     日志处理  关闭事务
            return result;
        }



         public <T> T createProxy(Class<T> clazz)  {
             T t = null;
             try {
                 t = clazz.newInstance();
             } catch (InstantiationException e) {
                 e.printStackTrace();
             } catch (IllegalAccessException e) {
                 e.printStackTrace();
             }
             return (T) createProxy(t);
         }

    }
    interface Animal {
        //主业务
        void eat();
        void sleep();
    }
    static class Dog implements Animal {
        @Override
        public void eat() {
            System.out.println("狗狗在啃骨头！");
        }

        @Override
        public void sleep() {
            System.out.println("狗狗在午休！");
        }
    }
    //创建测试方法
    public static void main(String[] args) {
        AnimalJdkDynamicProxy proxy=new AnimalJdkDynamicProxy();
        Animal dog=  proxy.createProxy(Dog.class);
        dog.eat();
        System.out.println("**************************");
        dog.sleep();
    }


}
