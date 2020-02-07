package utils;

/**
 * 用户配置实例类
 *
 * @author Dragon1573
 */
public class Configurations {
    /**
     * 发件电子邮箱
     */
    public String email = "";
    /**
     * 发件服务器地址
     */
    public String smtp = "";
    /**
     * 邮箱登陆密码
     */
    public String password = "";

    /**
     * 设置配置
     *
     * @param item 配置键
     * @param value 配置值
     */
    public void set(final String item, final String value) {
        if (Constants.EMAIL.equals(item)) {
            email = value;
        } else if (Constants.SMTP.equals(item)) {
            smtp = value;
        } else if (Constants.KEY.equals(item)) {
            password = value;
        }
    }

    public void show(final String item) {
        if (Constants.EMAIL.equals(item)) {
            System.out.println(email);
        } else if (Constants.SMTP.equals(item)) {
            System.out.println(smtp);
        } else if (Constants.KEY.equals(item)) {
            System.out.println("*".repeat(password.length()));
        }
    }
}
