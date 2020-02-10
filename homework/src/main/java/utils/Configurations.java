package utils;

/**
 * 用户配置实例类
 *
 * @author Dragon1573
 */
public class Configurations {
    private String email = "";
    private String smtp = "";
    private String password = "";

    /**
     * 设置配置
     *
     * @param item
     *     配置键
     * @param value
     *     配置值
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
            System.out.println(getEmail());
        } else if (Constants.SMTP.equals(item)) {
            System.out.println(getSmtp());
        } else if (Constants.KEY.equals(item)) {
            System.out.println("*".repeat(getPassword().length()));
        }
    }

    /**
     * 发件电子邮箱
     */
    public final String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * 发件服务器地址
     */
    public final String getSmtp() {
        return smtp;
    }

    public void setSmtp(final String smtp) {
        this.smtp = smtp;
    }

    /**
     * 邮箱登陆密码
     */
    public final String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * 检查用户配置是否为空
     *
     * @return {@code boolean}
     */
    public final boolean isUnset() {
        return (
            "".equals(getEmail()) && "".equals(getSmtp()) && "".equals(getPassword())
        );
    }
}
