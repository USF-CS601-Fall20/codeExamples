package nestedClasses.anonymous;

public interface Lockable {

    boolean lock(String key);
    boolean unlock(String key);

}
