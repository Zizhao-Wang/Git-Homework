package functions;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Scanner;

import static constants.Commands.ONE;
import static constants.Commands.TWO;
import static javax.mail.Message.RecipientType.TO;

/**
 * 发送电子邮件
 *
 * @author Dragon1573
 * @author WLSYH
 */
public class Push {
    /**
     * 发件人地址&&默认地址
     */
    private String from = null;
    private String default_from = null;
    /**
     * 发件服务器
     */
    private String host = null;
    /**
     * 发件服务器密码
     */
    private String key = "";

    /**
     * 主动作
     */
    public static void actions(final String[] args) {
        Push push = new Push();
        push.interact();
        System.out.println();
        if (push.send(args[ONE], args[TWO])) {
            System.out.println("[Info] Send succeeded :-)");
        } else {
            System.err.println("[Error] Send failed :-(");
        }
    }

    /**
     * 交互式获取发件人信息
     */
    private void interact() {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                // 发件人地址
                System.out.print("From: ");
                from = scanner.nextLine();
                if (default_from == null) {
                    System.out.print("DefaultFrom: ");
                    default_from = scanner.nextLine();
                }
            } while (from == null || "".equals(from));
            do {
                // 发件服务器
                System.out.print("Host: ");
                host = scanner.nextLine();
            } while (host == null || "".equals(from));
            do {
                // 登陆密码
                System.out.print("Password: ");
                // 输入密码不回显
                try {
                    // 生产环境下，输入来自命令行
                    key = new String(System.console().readPassword());
                } catch (NullPointerException e) {
                    // 测试环境下，输入来自文件
                    key = scanner.nextLine();
                }
            } while ("".equals(key));
        }
    }

    /**
     * 发送电子邮件
     *
     * @return 邮件发送成功反馈
     */
    public boolean send(final String filePath, String address) {
        if (address == null) {
            address = default_from;
        }
        boolean isSuccess = false;
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置发信服务器
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", true);

        // 全程SSL登录（使用HTTPS连接）
        try {
            MailSSLSocketFactory factory = new MailSSLSocketFactory();
            // 信任一切SSL服务器
            factory.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", true);
            properties.put("mail.smtp.ssl.socketFactory", factory);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        // 获取默认发信会话
        Session session = Session.getDefaultInstance(
                properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, key);
                    }
                }
        );

        // 发送带附件的电子邮件
        try {
            MimeMessage message = new MimeMessage(session);
            // 设置发件人||
            message.setFrom(new InternetAddress(from));


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
            e.printStackTrace();
        }
        return isSuccess;
    }
}
