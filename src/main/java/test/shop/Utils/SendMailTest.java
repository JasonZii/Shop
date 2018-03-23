package test.shop.Utils;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

@Aspect
public class SendMailTest {

    /*public static void main(String[] args) throws MessagingException {

//        Locale locale = new Locale("zh","CN");
//        ResourceBundle bundle = ResourceBundle.getBundle("Test",locale);

//        ResourceBundle bundle = ResourceBundle.getBundle("Test");
//        System.out.println(bundle.getString("password"));

        MailUtils.sendMail("jasonzii@163.com",
                "23456",
                "恭喜您");
    }*/

    @Autowired
    private MailUtils m;


    @Before(value = "execution(public * test.shop.service.impl.LoginServiceImpl.findUserByName(..))")
    public void send() throws Exception {

        m.sendMail("jasonzii@163.com","234","nfhsdfdsargf");

    }

}
