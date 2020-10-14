package concurrency.threadPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class MultithreadedJsonFileCounter {
    private ExecutorService exec = null;
    private int count;
    private Phaser phaser;
    private static final Logger logger = LogManager.getLogger();


    public MultithreadedJsonFileCounter() {
        logger.debug("In the constructor");
        count = 0;
        exec = Executors.newCachedThreadPool();
        phaser = new Phaser();
    }

    public synchronized void incrementCount() {
        count++;
    }

    public synchronized void incrementCount(int dirCount) {
        count += dirCount;
    }

    private class Worker implements Runnable {
        Path dir;
        int dirCount = 0;

        Worker(Path dir) {
            this.dir = dir;
        }

        @Override
        public void run() {
            if (!Files.isDirectory(dir))
                return;
            try (DirectoryStream<Path> filesAndFolders = Files.newDirectoryStream(dir)) {
                for (Path path: filesAndFolders) {
                    if (Files.isDirectory(path)) {
                        //System.out.println(Thread.currentThread().getName() + "  assigned directory " + path);
                        logger.debug(Thread.currentThread().getName() + "  assigned directory " + path);
                        Worker worker = new Worker(path);
                        phaser.register();
                        exec.submit(worker);
                    }
                    else {
                        if (path.toString().endsWith(".json")) {
                            System.out.println(path);
                            dirCount++;
                            // incrementCount();
                        }
                    }
                }
                incrementCount(dirCount);
                phaser.arrive();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void countFiles(Path directory) {
        if (!Files.isDirectory(directory))
            return;
        int phase = phaser.getPhase();
        Worker worker = new Worker(directory);
        phaser.register();
        exec.submit(worker);
        phaser.awaitAdvance(phase);
        System.out.println(getCount());
        shutdownExecutorService();
    }

    public synchronized int getCount() {
        return count;
    }

    public void shutdownExecutorService() {
        exec.shutdown();
        try {
            exec.awaitTermination(10000, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        MultithreadedJsonFileCounter fileCounter = new MultithreadedJsonFileCounter();
        fileCounter.countFiles(Paths.get("input/reviews"));


    }
}
