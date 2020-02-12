package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import utils.Constants;

/**
 * 集成测试
 *
 * @author Dragon1573
 */
public class IntegratedTest {
    static void archiveTest() {
        System.out.println(
            "$ homework archive archived src"
        );
        App.main(new String[] {
            "archive", "archived", "src"
        });
        System.out.println();
        System.out.println();
    }

    static void configTestB() {
        System.out.println("$ homework config user.email");
        App.main(new String[] {Constants.CONFIG, Constants.EMAIL});
        System.out.println();
        System.out.println();
        System.out.println("$ homework config user.smtp");
        App.main(new String[] {Constants.CONFIG, Constants.SMTP});
        System.out.println();
        System.out.println();
        System.out.println("$ homework config user.key");
        App.main(new String[] {Constants.CONFIG, Constants.KEY});
        System.out.println();
        System.out.println();
    }

    static void configTestA() {
        String[] configs = {
            System.getenv("USER_EMAIL"),
            System.getenv("USER_HOST"),
            System.getenv("USER_KEY")
        };
        assert configs[0] != null;
        assert configs[1] != null;
        assert configs[2] != null;
        System.out.println("$ homework config user.email student@example.com");
        App.main(new String[] {Constants.CONFIG, Constants.EMAIL, configs[0]});
        System.out.println();
        System.out.println();
        System.out.println("$ homework config user.smtp smtp.example.com");
        App.main(new String[] {Constants.CONFIG, Constants.SMTP, configs[1]});
        System.out.println();
        System.out.println();
        System.out.println("$ homework config user.key ****************");
        App.main(new String[] {Constants.CONFIG, Constants.KEY, configs[2]});
        System.out.println();
        System.out.println();
    }

    static void pushTest() {
        // 输入重定向
        InputStream rawIn = System.in;
        try {
            System.setIn(new FileInputStream(new File("src/test/resources/comments.txt")));
        } catch (FileNotFoundException e) {
            System.err.println(e.getLocalizedMessage());
            throw new AssertionError("[Error] File not found!", e);
        }

        // 发信测试
        System.out.println("$ homework push archived.zip teacher@example.com");
        App.main(new String[] {
            Constants.PUSH, "archived.zip",
            System.getenv("TARGET_EMAIL")
        });
        System.out.println();
        System.out.println();

        // 还原标准输入
        System.setIn(rawIn);
    }
}
