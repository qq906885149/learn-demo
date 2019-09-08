package guanchazhemoshi.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @Auther : ChenZhongChuang
 * @Date : 2019/9/8 11:27
 * @Descoription :
 */
@Component
public class MyEvent extends ApplicationEvent {


    public MyEvent(ApplicationContext source) {
        super(source);
        System.out.println("MyEvent 构造器执行");
    }

    public void echo() {
        System.out.println("MyEvent模拟业务逻辑执行");
    }
}
