package main;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void helpTestA() {
        App.main(new String[] {"-h"});
    }

    @Test
    public void helpTestB() {
        App.main(new String[] {"--help"});
    }

    @Test
    public void versionTestA() {
        App.main(new String[] {"-v"});
    }

    @Test
    public void versionTestB() {
        App.main(new String[] {"--version"});
    }

    /*
     * TODO: 邮件发送测试
     *
     * 关于邮件发送这个测试，我就没有做自动化测试了。
     * 邮件发送涉及到邮箱账号、SMTP服务器、邮箱密码/授权码，
     * 这些属于隐私信息，不能上传到GitHub仓库中。
     * 而用于保护隐私的GitHub Secrets我还不知道怎么用，
     * 所以邮件发送功能还需要你们拉取到本地后在本地进行测试。
     */
}
