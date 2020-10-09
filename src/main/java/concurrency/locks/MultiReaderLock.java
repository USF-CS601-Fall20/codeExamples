package concurrency.locks;

public class MultiReaderLock {
    private int readers, writers;

    public MultiReaderLock() {
        readers = 0;
        writers = 0;
    }

    public synchronized void lockRead() {
        while (writers > 0) {
            try {
                this.wait();
            }
            catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        readers++;
    }

    public synchronized void unlockRead() {
        if (readers == 0)
            return;
        readers--;
        if (readers == 0)
            this.notifyAll();

    }

    public synchronized void lockWrite() {
        // FILL IN CODE
    }

    public synchronized void unlockWrite() {
        // FILL IN CODE
    }

}
