package cn.cxy.test.Network;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/4/24 16:25 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class MailTest {

    public static void main(String[] args){
        Properties props = new Properties();
        try {
            /**
             * 配置文件格式
             *  Sender
             *  Recipient
             *  Subject
             *  Message text
             */
            InputStream in = Files.newInputStream(Paths.get("mail","mail.properties"));
            props.load(in);
            List<String> lines = Files.readAllLines(Paths.get(args[0]), Charset.forName("UTF-8"));
            String from = lines.get(0);
            String to = lines.get(1);
            String subject = lines.get(2);
            StringBuilder builder = new StringBuilder();
            for (int i = 3;i<lines.size();i++){
                builder.append(lines.get(i));
                //cxy SMTP规范规定：每一行都需要以 \r 再紧跟一个 \n 结尾
                builder.append("\n");
            }
            Console console = System.console();
            String password = new String(console.readPassword("Password: "));
            Session mailSession = Session.getDefaultInstance(props);
            //开启详细日志
            //mailSession.setDebug(true);
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(to)});
            message.setSubject(subject);
            message.setText(builder.toString());
            Transport tr = mailSession.getTransport();
            try {
                tr.connect(null,password);
                tr.sendMessage(message,message.getAllRecipients());
            }finally {
                tr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
