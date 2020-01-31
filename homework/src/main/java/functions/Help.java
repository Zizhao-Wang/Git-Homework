package functions;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

/**
 * 显示命令行使用帮助
 *
 * @author Dragon1573
 */
public class Help {
    public static void print() {
        URL url = Help.class.getResource("../help.txt");
        File file = new File(url.getFile());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
