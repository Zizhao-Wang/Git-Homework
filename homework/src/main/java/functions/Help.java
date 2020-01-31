package functions;

import java.io.IOException;
import java.io.InputStream;

/**
 * 显示命令行使用帮助
 *
 * @author Dragon1573
 */
public class Help {
    public static void print() {
        InputStream stream = Help.class.getResourceAsStream("../help.txt");
        try {
            byte[] bytes = stream.readAllBytes();
            System.out.print(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
