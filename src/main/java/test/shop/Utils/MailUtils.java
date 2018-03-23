package test.shop.Utils;

import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {


	//email:收件人  subject:主题  emailMsg:邮件的内容   注：发件人需要在邮箱上打开SMTP服务（sina）已开
	public static void sendMail(String email, String subject, String emailMsg)
			throws AddressException, MessagingException {
        //0.设置配置文件
        final ResourceBundle bundle = ResourceBundle.getBundle("mail");


        // 1.创建一个程序与邮件服务器会话对象 Session

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "SMTP");//发邮件的协议
		props.setProperty("mail.host", "smtp."+bundle.getString("mail")+".com");//发送邮件的服务器地址
		props.setProperty("mail.smtp.auth", "true");// 指定验证为true

		// 创建验证器

		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(bundle.getString("username"),bundle.getString("password"));//发邮件的账号密码
			}
		};

		Session session = Session.getInstance(props, auth);

		// 2.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress(bundle.getString("username")+"@"+bundle.getString("mail")+".com")); // 设置发送者

		message.setRecipient(RecipientType.TO, new InternetAddress(email)); // 设置接收者

		message.setSubject(subject);//邮件的主题

		message.setContent(emailMsg, "text/html;charset=utf-8");

		// 3.创建 Transport用于将邮件发送

		Transport.send(message);
	}
}
