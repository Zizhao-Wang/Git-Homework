package main;

import functions.Archive;
import functions.Config;
import functions.Help;
import functions.Push;
import utils.Constants;

/**
 * 主程序
 *
 * @author Dragon1573
 */
public class App {
    private static final String VERSION = "0.4.0";

    /**
     * 主函数
     *
     * @param args
     *     命令行参数
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            // 没有指定参数/命令时，输出帮助文档
            Help.print();
        } else {
            // 根据指令进行功能跳转
            switch (args[0]) {
                case Constants.SHORT_HELP:
                case Constants.LONG_HELP:
                    // 帮助文档
                    Help.print();
                    break;

                case Constants.SHORT_VERSION:
                case Constants.LONG_VERSION:
                    // 版本信息
                    System.out.println("homework version " + VERSION + "-jre11");
                    break;

                case Constants.PUSH:
                    // 作业推送（发送电子邮件）
                    if (args.length < Constants.THREE) {
                        System.err.println("Arguments incomplete!");
                        System.err.println();
                        System.err.println("Type 'homework -h' for help.");
                    } else {
                        Push.actions(args);
                    }
                    break;

                case Constants.CONFIG:
                    // 用户配置
                    if (args.length < Constants.TWO) {
                        System.err.println("Argument incomplete!");
                        System.err.println();
                        System.err.println("Type 'homework -h' for help.");
                    } else {
                        Config.actions(args);
                    }
                    break;

                case Constants.ARCHIVE:
                    // 创建压缩归档文件
                    if (args.length < Constants.THREE) {
                        System.err.println("Argument incomplete!");
                        System.err.println();
                        System.err.println("Type 'homework -h' for help.");
                    } else {
                        Archive.compress(args);
                    }
                    break;

                default:
                    // 返回命令更正提示
                    if (args[0].startsWith(Constants.OPTION_PREFIX)) {
                        System.err.println("Unknown option: " + args[0]);
                    } else {
                        System.err.println(
                            "'" + args[0] + "' is not an available command!");
                    }
                    System.err.println();
                    System.err.println("Type 'homework -h' for help.");
            }
        }
    }
}
