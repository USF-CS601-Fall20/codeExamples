package equalsMethod;

import java.awt.*;

/** Preserves transitivity, but breaks Liskov substitution principle and symmetry.
   when we try to override ColorPoint's equals method.
 (Liskov: any important property of a class should hold for all of its subclasses"
 * From "Effective Java" by Joshua Bloch. */
public class ColorPointV3 extends Point {
    private Color color;

    public ColorPointV3(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + color;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if ((other.getClass() !=  this.getClass())) // getClass for Point will be different from getClass for ColorPoint
            return false;
        if (other instanceof ColorPointV3)
            return super.equals(other) && ((ColorPointV3)other).color.equals(color);
        return false;
    }
}
