package functions;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static java.util.Objects.requireNonNull;

/**
 * 显示命令行使用帮助
 *
 * @author Dragon1573
 */
public class Help {
    public static void print() {
        ClassLoader loader = Help.class.getClassLoader();
        InputStream stream = loader.getResourceAsStream("help.txt");
        byte[] bytes = new byte[0];
        try {
            bytes = requireNonNull(stream).readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 此处必须显示指明使用的字符集
        // 使用简体中文的Windows默认字符集为GBK
        System.out.print(new String(bytes, StandardCharsets.UTF_8));
    }
}
