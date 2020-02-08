package main;

import java.io.FileInputStream;
import java.io.IOException;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import utils.Configurations;
import utils.Constants;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public synchronized void illegalTestA() {
        System.out.println("$ homework --error");
        App.main(new String[] {"--error"});
        System.out.println();
    }

    @Test
    public synchronized void illegalTestB() {
        System.out.println("$ homework error");
        App.main(new String[] {"error"});
        System.out.println();
    }

    @Test
    public synchronized void helpTestA() {
        System.out.println("$ homework -h");
        App.main(new String[] {Constants.SHORT_HELP});
        System.out.println();
    }

    @Test
    public synchronized void helpTestB() {
        System.out.println("$ homework --help");
        App.main(new String[] {Constants.LONG_HELP});
        System.out.println();
    }

    @Test
    public synchronized void helpTestC() {
        System.out.println("$ homework");
        App.main(new String[] {});
        System.out.println();
    }

    @Test
    public synchronized void versionTestA() {
        System.out.println("$ homework -v");
        App.main(new String[] {Constants.SHORT_VERSION});
        System.out.println();
    }

    @Test
    public synchronized void versionTestB() {
        System.out.println("$ homework --version");
        App.main(new String[] {Constants.LONG_VERSION});
        System.out.println();
    }

    @Test
    public synchronized void integratedTest() {
        configTestB();
        configTestA();
        configTestB();
        pushTest();
    }

    private void configTestB() {
        System.out.println("$ homework config user.email");
        App.main(new String[] {Constants.CONFIG, Constants.EMAIL});
        System.out.println();
        System.out.println("$ homework config user.smtp");
        App.main(new String[] {Constants.CONFIG, Constants.SMTP});
        System.out.println();
        System.out.println("$ homework config user.key");
        App.main(new String[] {Constants.CONFIG, Constants.KEY});
        System.out.println();
    }

    private void configTestA() {
        try {
            FileInputStream jsonStream =
                new FileInputStream("src/test/resources/config.json");
            String json = new String(jsonStream.readAllBytes());
            Configurations configurations = JSON.parseObject(
                json, Configurations.class
            );
            System.out.println("$ homework config user.email " + configurations
                .getEmail());
            App.main(new String[] {
                Constants.CONFIG, Constants.EMAIL, configurations.getEmail()
            });
            System.out.println();
            System.out.println("$ homework config user.smtp " + configurations.getSmtp());
            App.main(new String[] {
                Constants.CONFIG, Constants.SMTP, configurations.getSmtp()
            });
            System.out.println();
            System.out.println("$ homework config user.key ****************");
            App.main(new String[] {
                Constants.CONFIG, Constants.KEY, configurations.getPassword()
            });
            System.out.println();
        } catch (IOException e) {
            // 读写错误
            e.printStackTrace();
            assert false;
        }
    }

    private void pushTest() {
        System.out.println(
            "$ homework push src/test/resources/Izumi_Sagiri.png Legend_1949@126.com"
        );
        // 发信测试
        App.main(new String[] {
            Constants.PUSH,
            "src/test/resources/Izumi_Sagiri.png",
            "Legend_1949@126.com"
        });
        System.out.println();
    }
}
