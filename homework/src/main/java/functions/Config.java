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

package functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;

import utils.Configurations;
import utils.Constants;

/**
 * 创建用户配置文档
 *
 * @author Dragon1573
 */
public class Config {
    /**
     * 全局配置文件路径
     */
    private static final String GLOBAL_CONF = System.getProperty("user.home")
                                              + File.separator + ".homework"
                                              + File.separator + "config.json";

    public static void actions(String[] args) {
        switch (args[Constants.ONE]) {
            case Constants.EMAIL:
            case Constants.SMTP:
            case Constants.KEY:
            case Constants.DEFAULT_TARGET:
                Configurations configurations = load();
                if (args.length >= Constants.THREE) {
                    // 存在第三参数，则进行设置
                    configurations.set(args[Constants.ONE], args[Constants.TWO]);
                    save(configurations);
                } else {
                    // 否则读取并显示相应配置
                    configurations.show(args[Constants.ONE]);
                }
                break;

            default:
                System.err.println("[Waring] Settings unknown!");
                System.out.println();
                System.out.println("Please");
                break;
        }
    }

    /**
     * 载入配置
     */
    public static Configurations load() {
        Configurations configurations = new Configurations();
        try (FileInputStream stream = new FileInputStream(new File(GLOBAL_CONF))) {
            String json = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
            Configurations temp = JSON.parseObject(json, Configurations.class);
            if (temp != null) {
                configurations = temp;
            }
        } catch (IOException ignored) {}
        return configurations;
    }

    /**
     * 写入文件
     */
    private static void save(final Configurations configurations) {
        File file = new File(GLOBAL_CONF);
        File parents = file.getParentFile();
        if (!parents.exists()) {
            parents.mkdir();
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter writer = new PrintWriter(file, StandardCharsets.UTF_8);
            String json = JSON.toJSONString(configurations, true);
            writer.write(json);
            // 内容其实还在缓存上，必须刷入文件中
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new AssertionError("[Error] Can't save your profile!", e);
        }
    }
}
