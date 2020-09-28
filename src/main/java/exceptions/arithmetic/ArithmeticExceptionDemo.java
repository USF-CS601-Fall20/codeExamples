package exceptions.arithmetic;

import java.io.IOException;

public class ArithmeticExceptionDemo {
    public static void main(String[] args) {
        doSomething();
    }

    public static void doSomething() {
        int a = 5;
        int b = 0;
        try {
            int c = a / b;
            System.out.println(c);
        }
        catch (Exception e) {
            System.out.println("Cannot divide by 0.");
        }
        finally {
            System.out.println("This will be executed regardless of whether exception occurs or not.");
        }
        System.out.println("I am outside the finally block");

    }

}
