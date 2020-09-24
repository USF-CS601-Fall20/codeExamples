package exceptions.customExceptions;

public class StackEmptyException  extends  RuntimeException {
    public StackEmptyException() {
        System.out.println("The stack is empty!");
    }
}
