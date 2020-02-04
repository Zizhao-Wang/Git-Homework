package main;

import java.io.IOException;

import constants.Commands;
import constants.Long;
import constants.Short;
import functions.Help;
import functions.Push;

/**
 * 主程序
 *
 * @author Dragon1573
 */
public class App {
    private static final String VERSION = "0.2.1";

    /**
     * 主函数
     *
     * @param args
     *     命令行参数
     */
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            // 没有指定参数/命令时，输出帮助文档
            Help.print();
        }

        // 根据指令进行功能跳转
        switch (args[0]) {
            case Short.HELP:
            case Long.HELP:
                // 帮助文档
                Help.print();
                break;

            case Short.VERSION:
            case Long.VERSION:
                // 版本信息
                System.out.println("homework version" + VERSION + "-jre11");
                break;

            case Commands.PUSH:
                // 作业推送（发送电子邮件）
                if (args.length != Commands.THREE) {
                    new IllegalArgumentException("Arguments incomplete!")
                        .printStackTrace();
                    System.out.println();
                    System.out.println("Type 'homework -h' for help.");
                } else {
                    Push.actions(args);
                }
                break;

            default:
                new IllegalArgumentException("Unknown arguments or commands!")
                    .printStackTrace();
                System.out.println();
                System.out.println("Type 'homework -h' for help.");
        }
    }
}
