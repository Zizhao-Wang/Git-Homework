package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void helpTestA() throws IOException {
        App.main(new String[] {"-h"});
    }

    @Test
    public void helpTestB() throws IOException {
        App.main(new String[] {"--help"});
    }

    @Test
    public void versionTestA() throws IOException {
        App.main(new String[] {"-v"});
    }

    @Test
    public void versionTestB() throws IOException {
        App.main(new String[] {"--version"});
    }

    @Test
    public void pushTest() throws IOException {
        // 输入流重定向
        InputStream rawIn = System.in;
        System.setIn(new FileInputStream("src/test/resources/config.txt"));

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
