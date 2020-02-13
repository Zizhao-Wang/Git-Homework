/*
 * MIT License
 *
 * Copyright (c) 2020 Dragon1573
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
    private String target = "";

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
        } else if (Constants.DEFAULT_TARGET.equals(item)) {
            target = value;
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
        } else if (Constants.DEFAULT_TARGET.equals(item)) {
            System.out.println(getTarget());
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
