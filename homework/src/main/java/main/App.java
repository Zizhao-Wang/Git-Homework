package main;

import constants.Long;
import constants.Short;
import functions.Help;

/**
 * 主程序
 *
 * @author Dragon1573
 */
public class App {
    private static final String VERSION = "0.1.0";

    /**
     * 主函数
     *
     * @param args
     *     命令行参数
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            Help.print();
        } else if (Short.HELP.equals(args[0]) || Long.HELP.equals(args[0])) {
            Help.print();
        } else if (Short.VERSION.equals(args[0]) || Long.VERSION.equals(args[0])) {
            System.out.println("homework version " + VERSION + "-jre11");
        }
    }
}
