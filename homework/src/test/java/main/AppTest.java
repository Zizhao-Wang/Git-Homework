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

package main;

import java.io.IOException;

import org.junit.Test;

import utils.Constants;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public synchronized void illegalTestA() throws IOException {
        System.out.println("$ homework --error");
        App.main(new String[] {"--error"});
        System.out.println();
        System.out.println();
    }

    @Test
    public synchronized void illegalTestB() throws IOException {
        System.out.println("$ homework error");
        App.main(new String[] {"error"});
        System.out.println();
        System.out.println();
    }

    @Test
    public synchronized void helpTestA() throws IOException {
        System.out.println("$ homework -h");
        App.main(new String[] {Constants.SHORT_HELP});
        System.out.println();
        System.out.println();
    }

    @Test
    public synchronized void helpTestB() throws IOException {
        System.out.println("$ homework --help");
        App.main(new String[] {Constants.LONG_HELP});
        System.out.println();
        System.out.println();
    }

    @Test
    public synchronized void helpTestC() throws IOException {
        System.out.println("$ homework");
        App.main(new String[] {});
        System.out.println();
        System.out.println();
    }

    @Test
    public synchronized void versionTestA() throws IOException {
        System.out.println("$ homework -v");
        App.main(new String[] {Constants.SHORT_VERSION});
        System.out.println();
        System.out.println();
    }

    @Test
    public synchronized void versionTestB() throws IOException {
        System.out.println("$ homework --version");
        App.main(new String[] {Constants.LONG_VERSION});
        System.out.println();
        System.out.println();
    }

    @Test
    public synchronized void integratedTest() throws IOException {
        // 集成测试
        IntegratedTest.archiveTest();
        IntegratedTest.configTestB();
        IntegratedTest.configTestA();
        IntegratedTest.configTestB();
        IntegratedTest.pushTest();
    }
}
