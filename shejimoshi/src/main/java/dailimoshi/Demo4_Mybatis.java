package dailimoshi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * mybatis 动态代理实现
 * mybatis 底层是通过sqlSession 去执行 sql
 * 这里用打印sql 来替代
 *
 * @Auther : ChenZhongChuang
 * @Date : 2019/9/7 15:55
 * @Descoription :
 */
public class Demo4_Mybatis {

    static class MybatisJdkDynamicProxy<T> implements InvocationHandler{
        /**
         * 根据接口类生成代理对象
         * @Auther : CHENZC
         * @Date : 2019/9/7 16:57
         * @Param [clazz] Mapper 接口 class
         * @Return java.lang.Object 返回Mapper接口 的代理对象
         */
        public Object createProxy(Class clazz){
            //生成 clazz
            return Proxy.newProxyInstance(clazz.getClassLoader(),
                    new Class[]{clazz}, this);
        }

        /**
         * 通过 代理对象 去执行方法时，指向该方法
         * @Auther : CHENZC
         * @Date : 2019/9/7 16:59
         * @Param [proxy, method, args]
         * @Return java.lang.Object
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //如果是object 方法，就正常执行
            if (Object.class.equals(method.getDeclaringClass())) {
                try {
                    return method.invoke(this, args);
                } catch (Throwable t) {
                    throw t;
                }
            }
            //其他的就调用sqlSession 去查询，返回
            System.out.println(args[0]);
            return null;
        }
    }

    static interface UserMapper{
        void select(String haha);
    }
    public static void main(String[] args){
        MybatisJdkDynamicProxy proxy=new MybatisJdkDynamicProxy();
        UserMapper proxy1 = (UserMapper) proxy.createProxy(UserMapper.class);
        proxy1.select("hhhh");
    }

}
