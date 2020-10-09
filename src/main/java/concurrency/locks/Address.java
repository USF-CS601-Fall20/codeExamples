package concurrency.locks;

/** Address of a hotel */
public final class Address {
    private final String street;
    private final String city;
    private final String state;
    private final String country;

    /**
     *
     * @param street
     * @param city
     * @param state
     * @param country
     */
    public Address(String street, String city, String state, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    /** Copy constructor
     *
     * @param other
     */
    public Address(Address other) {
        this.street = other.street;
        this.city = other.city;
        this.state = other.state;
        this.country = other.country;
    }

    /**
     * toString method that return a string of the street, city, state and country
     * @return
     */
    @Override
    public String toString() {
        return "street: " + street + System.lineSeparator() +
                ", " +  city + System.lineSeparator() +
                ", " + state + System.lineSeparator() +
                ", " + country + System.lineSeparator();
    }
}
