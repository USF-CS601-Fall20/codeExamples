package equalsMethod;

// Demonstrates incorrect implementation of the equals method that breaks the symmetry requirement
public class EqualsEx {
    public static void main(String[] args) {

        CaseInsensitiveString string1 = new CaseInsensitiveString("Hello");
        String string2 = new String("hello"); // We do not need to use the new operator here; I left it so that it serves as a reminder that this variable is of type String
        System.out.println(string1.equals(string2)); // true
        System.out.println(string2.equals(string1)); // false
        // This breaks the equals contract! Should be symmetric, but it's not.

        // This is because the equals method in class String does not handle CaseInsensitive strings

    }
}
