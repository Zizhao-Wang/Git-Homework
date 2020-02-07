package functions;

import java.io.*;
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
    public static void actions(String[] args) {
        switch (args[Constants.ONE]) {
            case Constants.EMAIL:
            case Constants.SMTP:
            case Constants.KEY:
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
        try (
            FileInputStream stream = new FileInputStream(
                new File(".homework/config.json")
            )
        ) {
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
        File file = new File(".homework/config.json");
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
            assert false : "Can't save profiles!";
        }
    }
}
