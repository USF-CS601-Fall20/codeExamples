package equalsMethod;

import java.awt.*;

/** Demonstrates issues with transitivity when we try to override ColorPoint's equals method.
 * From "Effective Java" by Joshua Bloch. */
public class ColorPointV2 extends Point {
    private Color color;

    public ColorPointV2(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + color;
    }

    @Override
    public boolean equals(Object other) {
        System.out.println("Equals of ColorPointV2");
        if (this == other)
            return true;
        if (! (other instanceof Point)) // not a Point and not an object of a subclass of Point
            return false;
        if (other instanceof ColorPointV2)
            return super.equals(other) && ((ColorPointV2)other).color.equals(color);

        // other is Point, but not ColorPoint
        return other.equals(this); //((Point)other).equals(this);
    }
}
