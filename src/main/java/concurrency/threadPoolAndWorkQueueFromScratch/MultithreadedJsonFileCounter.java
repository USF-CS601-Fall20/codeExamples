package concurrency.threadPoolAndWorkQueueFromScratch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MultithreadedJsonFileCounter {
    private WorkQueue queue;
    private int count;
    private int pendingTasks;
    private static final Logger logger = LogManager.getLogger();


    public MultithreadedJsonFileCounter() {
        logger.debug("In the constructor");
        count = 0;
        queue = new WorkQueue();
        pendingTasks = 0;
    }

    public synchronized void incrementCount() {
        count++;
    }

    public synchronized void incrementCount(int dirCount) {
        count += dirCount;
    }

    public synchronized void incrementTasks() {
        pendingTasks++;
    }

    public synchronized void decrementTasks() {
        pendingTasks--;
        if (pendingTasks <= 0)
            this.notifyAll();
    }

    public synchronized int getTasks() {
        return pendingTasks;
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
                        incrementTasks();
                        //logger.debug("Incrementing one task");
                        queue.execute(worker); // give this runnable to the queue
                    }
                    else {
                        if (path.toString().endsWith(".json")) { // if a .json file, count it
                            System.out.println(path);
                            dirCount++; // efficient, since we update our local variable
                        }
                    }
                }
                incrementCount(dirCount); // combine our local count with the total count.

            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                logger.debug("Decrementing one task");
                decrementTasks(); // important! Says we are done with this task
            }
        }
    }

    public void countFiles(Path directory) {
        if (!Files.isDirectory(directory))
            return;
        Worker worker = new Worker(directory);
        incrementTasks();
        logger.debug("Incrementing one task");
        queue.execute(worker);

        System.out.println(getCount());
    }

    public synchronized void waitToFinish() {
        while (getTasks() != 0) {
            try {
                this.wait();
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        queue.shutdown();

    }
    public synchronized int getCount() {
        waitToFinish(); // want to return the result only after all threads finished
        return count;
    }


    public static void main(String[] args) {
        MultithreadedJsonFileCounter fileCounter = new MultithreadedJsonFileCounter();
        fileCounter.countFiles(Paths.get("input/reviews"));


    }
}
