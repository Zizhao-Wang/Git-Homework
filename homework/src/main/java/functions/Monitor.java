package functions;

import java.nio.file.*;

/**
 * @author WLcrm
 * @date 2020.2.6
 */
public class Monitor {
    String defaultFile = "D:\\WLcrm";
    String fileName = null;

    public Monitor() {
        monitor();
    }

    private void monitor() {
        try {
            Path monitorFile = Paths.get(defaultFile);
            WatchService watcher = FileSystems.getDefault().newWatchService();
            WatchKey key = null;
            monitorFile.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
            key = watcher.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                String fileName = defaultFile + "\\" + event.context();
                Push pushTemp = new Push();
                // TODO: 实现监控器与发信功能的交互
                if (Push.send(fileName, null)){
                    System.out.println("[Info] Send succeeded :-)");
                }
                else{
                    System.err.println("[Error] Send failed :-(");
                }
                fileName = null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

