package guanchazhemoshi;

import guanchazhemoshi.config.MyEvent;
import guanchazhemoshi.config.MyPublisher;

/**
 * 观察者模式是spring常用的一种设计模式
 *  @see org.springframework.context.ApplicationEvent：事件  继承自 jdk 的 {@link java.util.EventObject}
 *  所有的事件都需要继承 ApplicationEvent, 并且通过source得到事件源
 *  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 *  sping 提供的内置事件:
 *  @see org.springframework.context.event.ContextRefreshedEvent
 *  事件发布在 ApplicationContext 初始化或刷新时
 *  （例如：通过在 ConfigurableApplicationContext 接口使用refresh()方法）。
 *  这里,“初始化”意味着所有 bean 加载，post-processor bean 被检测到并且激活,单例预先实例化，ApplicationContext 对象可以使用了。
 *  只要上下文没有关闭,可以触发多次刷新, ApplicationContext 提供了一种可选择的支持这种“热”刷新。
 *  例如：XmlWebApplicationContext 支持热刷新,但 GenericApplicationContext 并非如此。
 *  具体是在 AbstractApplicationContext 的 finishRefresh() 方法中。
 *  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 *  @see org.springframework.context.event.ContextStartedEvent 事件发布在 ApplicationContext 开始使用
 *  {@link org.springframework.context.ConfigurableApplicationContext} 接口 start() 方法。
 *  这里,“开始”意味着所有生命周期 bean 接收到一个明确的起始信号。
 *  通常,这个信号用于明确停止后重新启动,但它也可以用于启动组件没有被配置为自动运行（例如：组件还没有开始初始化）。
 *  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 *  @see org.springframework.context.event.ContextStoppedEvent 事件发布在 ApplicationContext 停止时通过使用
 *  {@link org.springframework.context.ConfigurableApplicationContext} 接口上的 stop() 方法。
 *  在这里,“停止”意味着所有生命周期bean接收一个显式的停止信号。
 *  停止上下文可以通过重新调用start()方法。
 *  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 *  @see org.springframework.context.event.ContextClosedEvent 事件发布在 ApplicationContext 关闭时通过关闭
 *  ConfigurableApplicationContext 接口()方法。
 *  这里,“封闭”意味着所有单例 bean 被摧毁。一个封闭的环境达到生命的终结。它不能刷新或重启。
 *  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 *  @see org.springframework.web.context.support.RequestHandledEvent 一个特定的web事件告诉所有能处理HTTP请求的bean 。
 *  这个事件是在请求完成后发布的。这个事件只适用于使用 Spring 的 DispatcherServlet 的web应用程序。
 *
 *  》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》
 *  @see org.springframework.context.ApplicationListener 事件监听 继承自 jdk 的 {@link java.util.EventListener}
 *  该类中只有一个方法 onApplicationEvent。当监听的事件发生后该方法会被执行。
 *
 *  》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》
 *  @see org.springframework.context.ApplicationContext 事件发布
 *  Spring 中的核心容器，在事件监听中 ApplicationContext 可以作为事件的发布者，也就是事件源。
 *  因为 ApplicationContext 继承自 ApplicationEventPublisher。
 *  在 ApplicationEventPublisher 中定义了事件发布的方法 — publishEvent(Object event)
 *
 *  》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》
 *  @see org.springframework.context.event.ApplicationEventMulticaster 事件管理
 *  ApplicationEventMulticaster 用于事件监听器的注册和事件的广播。
 *  监听器的注册就是通过它来实现的，它的作用是把 Applicationcontext 发布的 Event 广播给它的监听器列表。
 *
 *  》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》
 * @Auther : ChenZhongChuang
 * @Date : 2019/9/8 10:12
 * @Descoription :
 */
public class Demo2_Spring {
    /**
     *  自定义需要发布的事件类，需要继承 ApplicationEvent 类或 PayloadApplicationEvent
     *  {@link org.springframework.context.ApplicationEvent,org.springframework.context.PayloadApplicationEvent}
     *  (该类也仅仅是对 ApplicationEvent 的一层封装)
     *  使用 @EventListener 来监听事件或者实现 ApplicationListener 接口。
     *  {@link org.springframework.context.ApplicationListener,org.springframework.context.event.EventListener}
     *  使用 ApplicationEventPublisher 来发布自定义事件（@Autowired注入即可）
     *  {@link org.springframework.context.ApplicationEventPublisher}
     * @Auther : CHENZC
     * @Date : 2019/9/8 11:06
     * @Param myPublisher
     * @param myEvent
     * @Return
     */
    public void test(MyPublisher myPublisher, MyEvent myEvent){
        myPublisher.publisherEvent(myEvent);
    }


}
