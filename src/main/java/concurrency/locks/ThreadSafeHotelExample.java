package concurrency.locks;

import java.util.Random;

public class ThreadSafeHotelExample {
    public static void main(String[] args) {
        Address address = new Address("345 Geary Street", "San Francisco", "CA", "USA");
        ThreadSafeHotel hotel = new ThreadSafeHotel("Holiday Inn", "123456", address);

        Thread thread1 = new Thread(() -> {
            hotel.setId("67890");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(hotel.getId());
        });
        thread1.start();
        thread2.start();

    }
}
