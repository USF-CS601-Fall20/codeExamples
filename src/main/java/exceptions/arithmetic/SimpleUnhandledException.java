package exceptions.arithmetic;

public class SimpleUnhandledException {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        test2();
    }
    public static void test2() {
        int a = 5 / 0;
    }
}
