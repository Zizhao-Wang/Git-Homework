package functions;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 创建归档压缩文件
 *
 * @author Dragon1573
 */
public class Archive {
    /**
     * 创建压缩文件
     *
     * @param args
     *     命令行参数
     */
    public static void compress(final String[] args) {
        // 目标压缩文件名
        String targetName = args[1] + ".zip";
        try {
            // 文件字节输出流
            FileOutputStream fileStream = new FileOutputStream(targetName);
            // 压缩文件输出流
            ZipOutputStream zipStream = new ZipOutputStream(
                new BufferedOutputStream(fileStream)
            );

            // 循环遍历命令行参数中的文件
            for (int i = 2; i < args.length; i++) {
                // 待压缩资源文件
                File resource = new File(args[i]);
                // 将资源添加到压缩文件中
                append(zipStream, resource, "");
            }

            // 关闭流
            zipStream.close();
            fileStream.close();
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
            System.err.println(
                "[Error] Cannot create the archive file! " +
                "Please try again ..."
            );
        }
    }

    /**
     * 递归添加资源文件/目录
     *
     * @param zipStream
     *     归档压缩文件输出流
     * @param file
     *     待归档文件/目录
     * @param folder
     *     归档内的当前目录
     */
    private static void append(ZipOutputStream zipStream, File file, String folder) {
        if (file.isDirectory()) {
            // 获取当前目录的文件（包括子目录）列表
            File[] files = file.listFiles();
            // 将文件夹添加到当前打包目录
            try {
                // 创建文件夹入口
                folder += file.getName() + File.separator;
                zipStream.putNextEntry(new ZipEntry(folder));

                // 递归归档子目录
                assert files != null : "[Error] I/O error occurs!";
                for (File value : files) {
                    append(zipStream, value, folder);
                }
            } catch (IOException e) {
                System.err.println(e.getLocalizedMessage());
                System.err.println(
                    "[Error] Cannot archive recursively! " +
                    "Please try again ..."
                );
            }
        } else {
            // 获取资源文件（自动关闭）
            try (FileInputStream fileStream = new FileInputStream(file)) {
                // 创建文件入口
                folder += file.getName();
                zipStream.putNextEntry(new ZipEntry(folder));

                // 写入文件
                byte[] contents = fileStream.readAllBytes();
                zipStream.write(contents);
            } catch (IOException e) {
                System.err.println(e.getLocalizedMessage());
                System.err.println(
                    "[Error] Cannot locate the file! " +
                    "Please make sure you gave us a correct path ..."
                );
            }
        }
    }
}
