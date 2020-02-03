package functions;

import java.io.IOException;
import java.io.InputStream;

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
        try {
            byte[] bytes = requireNonNull(stream).readAllBytes();
            System.out.print(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
