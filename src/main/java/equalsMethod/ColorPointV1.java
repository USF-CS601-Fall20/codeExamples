package equalsMethod;

import java.awt.*;

/** Demonstrates issues with transitivity when we try to override ColorPoint's equals method.
 * From "Effective Java" by Joshua Bloch. */
public class ColorPointV1 extends Point {
    private Color color;

    public ColorPointV1(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + color;
    }

    @Override
    public boolean equals(Object other) {
        //System.out.println("Equals of ColorPointV1");
        if (this == other)
            return true;
        if (! (other instanceof ColorPointV1))
            return false;
        return super.equals(other) && ((ColorPointV1)other).color.equals(color);
    }
}
