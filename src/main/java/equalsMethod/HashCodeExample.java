package equalsMethod;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

/** Demonstrates the importance of overriding hashCode when you override equals */
public class HashCodeExample {
    public static void main(String[] args) {
        Set<Point> pointsSet = new HashSet();

        Point p1 = new Point(50, 25);
        pointsSet.add(p1);
        pointsSet.add(new Point(1, 0));

        Point p2 = new Point(50, 25);

        System.out.println(pointsSet.contains(p1)); // true
        System.out.println(pointsSet.contains(p2)); // false
        System.out.println(p1.equals(p2)); // true (since Point overrides equal to compare x and y)
        System.out.println(p1.hashCode() + " " + p2.hashCode());


    }
}
