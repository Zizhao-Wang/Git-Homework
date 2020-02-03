package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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

    @Test
    public void pushTest() {
        // 输入流重定向
        InputStream rawIn = System.in;
        try {
            System.setIn(new FileInputStream("src/test/resources/config.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 发信测试
        App.main(new String[] {
            "push",
            "src/test/resources/Izumi_Sagiri.png",
            "Legend_1949@126.com"
        });

        // 还原标准输入流
        System.setIn(rawIn);
    }
}
