package com.example.ltserver;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailUtils {
    public static final String MY_EMAIL_ACCOUNT = "ltserver001@163.com";
    public static final String MY_EMAIL_PASSWORD = "JFUEPHTXSAZOKZKK";
    public static final String MAIL_163_SMTP_HOST = "smtp.163.com";
    public static final String SMTP_163_PORT = "25";

    public boolean sendMail(String RECEIVE_EMAIL_ACCOUNT, String subject, String msg) throws MessagingException {
        Properties p = new Properties();
        p.setProperty("mail.smtp.host", MAIL_163_SMTP_HOST);
        p.setProperty("mail.smtp.port", SMTP_163_PORT);
        p.setProperty("mail.smtp.socketFactory.port", SMTP_163_PORT);
        p.setProperty("mail.smtp.auth", "true");
        p.setProperty("mail.smtp.socketFactory.class", "SSL_FACTORY");

        Session session = Session.getInstance(p, new Authenticator() {
            // 设置认证账户信息
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MY_EMAIL_ACCOUNT, MY_EMAIL_PASSWORD);
            }
        });
        session.setDebug(true);
        System.out.println("创建邮件");
        MimeMessage message = new MimeMessage(session);
        // 发件人
        message.setFrom(new InternetAddress(MY_EMAIL_ACCOUNT));
        // 收件人和抄送人
        message.setRecipients(Message.RecipientType.TO, RECEIVE_EMAIL_ACCOUNT);
//		message.setRecipients(Message.RecipientType.CC, MY_EMAIL_ACCOUNT);

        message.setSubject(subject);
        message.setContent(msg, "text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        System.out.println("准备发送");
        Transport.send(message);

        return true;
    }

}
