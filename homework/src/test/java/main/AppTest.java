package main;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void helpTestA() {
        App.main(new String[] {"-h"});
    }

    @Test
    public void helpTestB() {
        App.main(new String[] {"--help"});
    }

    @Test
    public void versionTestA() {
        App.main(new String[] {"-v"});
    }

    @Test
    public void versionTestB() {
        App.main(new String[] {"--version"});
    }
}
