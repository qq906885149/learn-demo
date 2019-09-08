package guanchazhemoshi.config;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Auther : ChenZhongChuang
 * @Date : 2019/9/8 11:29
 * @Descoription :
 */
@Component
public class MyListenerB {

    @EventListener
    public void onA(MyEvent myEvent){
        System.out.println("MyListenerB");
        myEvent.echo();
    }
//    public void onApplicationEvent(MyEvent myEvent) {
//        System.out.println("MyListenerB");
//        myEvent.echo();
//    }

}