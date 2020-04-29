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

package main;

import java.io.*;

import utils.Constants;

/**
 * 集成测试
 *
 * @author Dragon1573
 */
public class IntegratedTest {
    private static final String errorMessage =
        "You haven't set your environment variables! "
        + "Please set variable: ";

    static void archiveTest() throws IOException {
        System.out.println(
            "$ homework archive archived src"
        );
        App.main(new String[] {
            "archive", "archived", "src"
        });
        System.out.println();
        System.out.println();
    }

    static void configTestB() throws IOException {
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
        System.out.println("$ homework config target.default");
        App.main(new String[] {Constants.CONFIG, Constants.DEFAULT_TARGET});
        System.out.println();
        System.out.println();
    }

    static void configTestA() throws IOException {
        String[] configs = {
            System.getenv("USER_EMAIL"),
            System.getenv("USER_HOST"),
            System.getenv("USER_KEY"),
            System.getenv("TARGET_EMAIL")
        };
        assert configs[0] != null : errorMessage + "USER_EMAIL";
        assert configs[1] != null : errorMessage + "USER_HOST";
        assert configs[2] != null : errorMessage + "USER_KEY";
        assert configs[3] != null : errorMessage + "TARGET_EMAIL";
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
        System.out.println("$ homework config target.default teacher@example.com");
        App.main(new String[] {Constants.CONFIG, Constants.DEFAULT_TARGET, configs[3]});
        System.out.println();
        System.out.println();
    }

    static void pushTest() throws IOException {
        // 输入重定向
        InputStream rawIn = System.in;
        try {
            System.setIn(new FileInputStream(
                new File("src/test/resources/comments.txt")
            ));
        } catch (FileNotFoundException e) {
            System.err.println(e.getLocalizedMessage());
            throw new AssertionError("[Error] File not found!", e);
        }

        // 发信测试
        System.out.println("$ homework push archived.zip");
        App.main(new String[] {Constants.PUSH, "archived.zip"});
        System.out.println();
        System.out.println();

        // 还原标准输入
        System.setIn(rawIn);
    }
}
