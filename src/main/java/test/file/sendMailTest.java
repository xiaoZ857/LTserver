package test.file;

import com.example.ltserver.MailUtils;

import javax.mail.MessagingException;

public class sendMailTest {

    public static void main(String[] args) throws MessagingException {
        MailUtils m = new MailUtils();
        boolean flag = m.sendMail("786187157@qq.com", "一封有味道的邮件", "雷猴啊，我是旺仔");
        if (flag){
            System.out.println("发送成功");
        }else{
            System.out.println("发送失败");
        }
    }
}
