package nestedClasses.anonymous;

import java.util.concurrent.locks.Lock;

public class LockableExample {
    public static void main(String[] args) {
        Lockable treasureChest = new Lockable() {
            @Override
            public boolean lock(String key) {
                return false;
            }

            @Override
            public boolean unlock(String key) {
                return false;
            }
        };
    }
}
