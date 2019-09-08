package guanchazhemoshi.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Auther : ChenZhongChuang
 * @Date : 2019/9/8 11:29
 * @Descoription :
 */
@Component
public class MyPublisher implements ApplicationContextAware {

    private ApplicationContext applicationContext;


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 发布事件
     * 监听该事件的监听者都可以获取消息
     *
     * @param myEvent
     */
    public void publisherEvent(MyEvent myEvent) {
        System.out.println("---MyPublisher开始发布 myEvent 事件---");
        applicationContext.publishEvent(myEvent);
    }
}
