package functions;

import java.security.GeneralSecurityException;
import java.util.Objects;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.util.MailSSLSocketFactory;

import utils.Configurations;

import static javax.mail.Message.RecipientType.TO;

import static utils.Constants.ONE;
import static utils.Constants.TWO;

/**
 * 发送电子邮件
 *
 * @author Dragon1573
 */
public class Push {
    /**
     * 主动作
     */
    public static void actions(final String[] args) {
        System.out.println();
        if (send(args[ONE], args[TWO])) {
            System.out.println("[Info] Send succeeded :-)");
        } else {
            System.out.println("[Info] Send failed :-(");
            throw new AssertionError();
        }
    }

    /**
     * 发送电子邮件
     *
     * @return 邮件发送成功反馈
     */
    private static boolean send(final String filePath, final String address) {
        Configurations configurations = Config.load();
        if (configurations.isUnset()) {
            System.err.println(
                "You haven't told us about yourself! " +
                "Please help us identify you by using command 'homework config'."
            );
        }
        boolean isSuccess = false;
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置发信服务器
        properties.setProperty(
            "mail.smtp.host",
            Objects.requireNonNull(configurations).getSmtp()
        );
        properties.put("mail.smtp.auth", true);

        // 全程SSL登录（使用HTTPS连接）
        try {
            MailSSLSocketFactory factory = new MailSSLSocketFactory();
            // 信任一切SSL服务器
            factory.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", true);
            properties.put("mail.smtp.ssl.socketFactory", factory);
        } catch (GeneralSecurityException e) {
            System.err.println(e.getLocalizedMessage());
            assert false : "Cannot create an SSL connection!";
        }

        // 获取默认发信会话
        Session session = Session.getDefaultInstance(
            properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                        configurations.getEmail(), configurations.getPassword()
                    );
                }
            }
        );

        // 发送带附件的电子邮件
        try {
            MimeMessage message = new MimeMessage(session);
            // 设置发件人
            message.setFrom(new InternetAddress(configurations.getEmail()));
            // 设置收件人
            message.addRecipient(TO, new InternetAddress(address));
            // 设置邮件主题
            // TODO: 这个内容应该可以在正式发行版中由用户指定
            //       此处仅作为GitHub Actions自动化测试用
            message.setSubject("[GitHub Actions] Apache Maven CI");

            // 创建邮件正文文本
            BodyPart bodyPart = new MimeBodyPart();
            // TODO: 这个内容应该可以在正式发行版中由用户指定
            //       此处仅作为GitHub Actions自动化测试用
            bodyPart.setText(
                "This email was sent by GitHub Action test. " +
                "Please just ignore it and do NOT reply!"
            );
            // 创建多重消息
            Multipart multipart = new MimeMultipart();
            // 添加文本部分
            multipart.addBodyPart(bodyPart);

            // 添加附件部分
            bodyPart = new MimeBodyPart();
            DataSource source;
            source = new FileDataSource(filePath);
            bodyPart.setDataHandler(new DataHandler(source));
            bodyPart.setFileName(filePath.substring(filePath.lastIndexOf('/') + 1));
            multipart.addBodyPart(bodyPart);

            // 添加完整消息
            message.setContent(multipart);
            // 发送邮件
            Transport.send(message);
            isSuccess = true;
        } catch (MessagingException e) {
            System.err.println(e.getLocalizedMessage());
        }
        return isSuccess;
    }
}
