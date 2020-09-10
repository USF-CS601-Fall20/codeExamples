package equalsMethod;

/** Breaks Liskov principle.
 * From "Effective Java" by Joshua Bloch. */
public class PointV3 {
    private int x, y;
    public PointV3(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    @Override
    public boolean equals(Object other) {
        //System.out.println("Equals of Point");
        if (this == other)
            return true;
        if (this.getClass() != other.getClass())
            return false;
        PointV3 otherPoint = (PointV3)other;
        if ((x == otherPoint.x) && (y == otherPoint.y))
            return true;
        return false;
    }

    // We must also override hashCode! We should do it whenever we override equals
   /* @Override
    public int hashCode() {
        return 31*((Integer)x).hashCode() + ((Integer)y).hashCode();
    }*/

    public int getX() {
        return x;

    }

    public int getY() {
        return y;

    }
}

