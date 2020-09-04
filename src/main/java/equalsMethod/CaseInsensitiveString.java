package equalsMethod;

/** This example demonstrates incorrect overriding of method equals.
 * It breaks the symmetry condition. See the main method.
 * The example is from the Effective Java book by J. Bloch.
 */
public class CaseInsensitiveString {
    private String string;

    public CaseInsensitiveString(String s) {
        this.string = s;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true; // same object
        }
        if (other instanceof  CaseInsensitiveString) {
            String otherString = ((CaseInsensitiveString)other).string;
            return this.string.equalsIgnoreCase(otherString);
        }
        // The code below is a problem: it breaks the symmetry property
        // If we want to stick to the equals contract, we'd need to remove it.
        else if (other instanceof String) {
            return this.string.equalsIgnoreCase(((String)other));
        }
        return false;
    }

}
