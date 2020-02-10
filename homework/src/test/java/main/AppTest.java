package main;

import org.junit.Test;

import utils.Constants;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public synchronized void illegalTestA() {
        System.out.println("$ homework --error");
        App.main(new String[] {"--error"});
        System.out.println();
        System.out.println();
    }

    @Test
    public synchronized void illegalTestB() {
        System.out.println("$ homework error");
        App.main(new String[] {"error"});
        System.out.println();
        System.out.println();
    }

    @Test
    public synchronized void helpTestA() {
        System.out.println("$ homework -h");
        App.main(new String[] {Constants.SHORT_HELP});
        System.out.println();
        System.out.println();
    }

    @Test
    public synchronized void helpTestB() {
        System.out.println("$ homework --help");
        App.main(new String[] {Constants.LONG_HELP});
        System.out.println();
        System.out.println();
    }

    @Test
    public synchronized void helpTestC() {
        System.out.println("$ homework");
        App.main(new String[] {});
        System.out.println();
        System.out.println();
    }

    @Test
    public synchronized void versionTestA() {
        System.out.println("$ homework -v");
        App.main(new String[] {Constants.SHORT_VERSION});
        System.out.println();
        System.out.println();
    }

    @Test
    public synchronized void versionTestB() {
        System.out.println("$ homework --version");
        App.main(new String[] {Constants.LONG_VERSION});
        System.out.println();
        System.out.println();
    }

    @Test
    public synchronized void integratedTest() {
        // 集成测试
        IntegratedTest.archiveTest();
        IntegratedTest.configTestB();
        IntegratedTest.configTestA();
        IntegratedTest.configTestB();
        IntegratedTest.pushTest();
    }
}
