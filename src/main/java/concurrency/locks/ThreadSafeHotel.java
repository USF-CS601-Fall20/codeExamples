package concurrency.locks;

public class ThreadSafeHotel extends Hotel {
    public ThreadSafeHotel(String name, String id, Address address) {
        super(name, id, address);
    }

    @Override
    public String getId() {

        return "";
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


    }

    @Override
    public String toString() {

        return "";
    }
}
