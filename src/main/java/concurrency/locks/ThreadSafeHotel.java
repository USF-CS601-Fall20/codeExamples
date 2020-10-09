package concurrency.locks;

public class ThreadSafeHotel extends Hotel {
    private MultiReaderLock lock;

    public ThreadSafeHotel(String name, String id, Address address) {
        super(name, id, address);
        lock  = new MultiReaderLock();
    }

    @Override
    public String getId() {
        String id = "";
        try {
            lock.lockRead();

            id = super.getId();
        }
        finally{
           lock.unlockRead();
           return id;
        }
    }

    @Override
    public Address getAddress() {

        return null;
    }

    @Override
    public void setName(String newName) {

    }

    @Override
    public void setId(String id) {
        try {
            lock.lockWrite();
            super.setId(id);
        }
        finally {
            lock.unlockWrite();
        }

    }

    @Override
    public String toString() {

        return "";
    }

}
