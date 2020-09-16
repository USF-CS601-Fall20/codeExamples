package equalsMethod;

/** Demonstrates issues with transitivity when we try to override ColorPoint's equals method.
 * From "Effective Java" by Joshua Bloch. */
public class Point {
    private int x, y;
    public Point(int x, int y) {
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
        if (! (other instanceof Point))
            return false;
        Point otherPoint = (Point)other;
        if ((x == otherPoint.x) && (y == otherPoint.y))
            return true;
        return false;
    }

    // We must also override hashCode! We should do it whenever we override equals
    @Override
    public int hashCode() {
        return 31*((Integer)x).hashCode() + ((Integer)y).hashCode();

    }

    public int getX() {
        return x;

    }

    public int getY() {
        return y;

    }
}

