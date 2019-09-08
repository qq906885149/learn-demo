package guanchazhemoshi.config;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Auther : ChenZhongChuang
 * @Date : 2019/9/8 11:28
 * @Descoription :
 */
@Component
public class MyListenerA implements ApplicationListener<MyEvent> {


    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println("MyListenerA");
        myEvent.echo();
    }
}
