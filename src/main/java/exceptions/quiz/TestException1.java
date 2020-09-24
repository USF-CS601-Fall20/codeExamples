package exceptions.quiz;

// Question1:   What will be printed by the following code? (Answer before running it)
// Question 2: What will happen if instead of Arithmetic exception,
// in func() we read from the file that did not exist, and in line 16, caught IOException
// Change the code accordingly and see what will happen.


public class TestException1 {

        public static void main(String[] args) {
            try {
                func();
                System.out.print("A");

            }
            catch (ArithmeticException ex) {
                System.out.print("B");
            }
            finally {
                System.out.print("C");
            }

            System.out.print("D");
        }

        public static void func() {

            // Division by zero, ArithmeticException
            System.out.println(5 / 0);

        }

}


