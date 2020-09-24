package exceptions.arithmetic;

public class SimpleUnhandledException {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int a = 5 / 0;
    }
}
