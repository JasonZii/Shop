package test.shop.listener;

import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import test.shop.http.bootstrap.ChatServer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.29  15:07
 */
public class ApplicationWatch implements ServletContextListener {

    @Autowired
    private ChatServer chatServer;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

 /*       new Thread(){
            new ChatServer.main
        }

        .start();
//    chatServer.startRun();


        System.out.println("asdfasfdasdf");*/
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
