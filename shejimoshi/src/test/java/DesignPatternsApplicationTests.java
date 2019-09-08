
import guanchazhemoshi.config.MyEvent;
import guanchazhemoshi.config.MyListenerA;
import guanchazhemoshi.config.MyListenerB;
import guanchazhemoshi.config.MyPublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Auther : ChenZhongChuang
 * @Date : 2019/9/8 11:29
 * @Descoription :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyEvent.class, MyListenerA.class, MyListenerB.class,MyPublisher.class})
public class DesignPatternsApplicationTests {

    @Autowired
    private MyPublisher myPublisher;
    @Autowired
    private MyEvent myEvent;

    @Test
    public void contextLoads() {myPublisher.publisherEvent(myEvent);

    }
}