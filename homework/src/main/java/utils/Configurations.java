package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户配置实例类
 *
 * @author Dragon1573
 */
public class Configurations {
    private String email = "";
    private String smtp = "";
    private String password = "";
    private String target = "";
    private List<String> targetList = new ArrayList<>();

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

    /**
     * 输出相应的配置
     *
     * @param item
     *     配置键
     */
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
     *
     * @return {@link String}
     */
    public final String getEmail() {
        return email;
    }

    /**
     * 设置发件邮箱地址
     *
     * @param email
     *     电子邮箱地址
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * 发件服务器地址
     *
     * @return {@link String}
     */
    public final String getSmtp() {
        return smtp;
    }

    /**
     * 设置发件服务器地址
     *
     * @param smtp
     *     发件SMTP服务器地址
     */
    public void setSmtp(final String smtp) {
        this.smtp = smtp;
    }

    /**
     * 邮箱登陆密码
     *
     * @return {@link String}
     */
    public final String getPassword() {
        return password;
    }

    /**
     * 设置发件密码/授权码
     *
     * @param password
     *     密码/授权码
     */
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

    /**
     * 获取默认收件地址
     *
     * @return {@link String}
     */
    public String getTarget() {
        return target;
    }

    /**
     * 设置默认收件人
     *
     * @param target
     *     默认收件人地址
     */
    public void setTarget(final String target) {
        this.target = target;
    }

    /**
     * 获取可选收件人列表
     *
     * @return {@link List}
     */
    public List<String> getTargetList() {
        return targetList;
    }

    /**
     * 设置可选收件人列表
     *
     * @param targetList 收件人列表
     */
    public void setTargetList(final List<String> targetList) {
        this.targetList = targetList;
    }
}
