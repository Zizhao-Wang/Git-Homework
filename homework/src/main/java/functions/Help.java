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
