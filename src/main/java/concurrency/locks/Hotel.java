package concurrency.locks;

public class Hotel {
    private String name;
    private String id;
    private  Address address;

    /**
     * Hotel Constructor
     * @param name
     * @param id
     * @param address
     */
    public Hotel(String name, String id, Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getId() {
        return this.id;
    } // Strings are immutable, so we are not breaking encapsulaiton

    public Address getAddress() {
        return new Address(this.address); // defensive copy; we do not return a reference to our instance variable
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * toString method that return a string of name, id, coordinate, address
     * @return
     */
    @Override
    public String toString() {
        return System.lineSeparator() +
                name + System.lineSeparator() +
                id + System.lineSeparator() +
                address.toString() + System.lineSeparator();
        }
}