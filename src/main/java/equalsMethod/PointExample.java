package equalsMethod;

import java.awt.*;

/** Demonstrates that there is no way to extend a non-abstract class
 * and add a field and preserve the equals contract. From Effective Java book.
 */
public class PointExample {
    public static void main(String[] args) {
        // Version 1: Breaks Symmetry
        //Point p1 = new Point(100, 200);
        // Point p3 = new ColorPointV1(100, 200, new Color(200, 0, 100));
        //ColorPointV1 p2 = new ColorPointV1(100, 200, new Color(200, 0, 100));
        //System.out.println(p2 instanceof  ColorPointV1);
        //System.out.println(p2 instanceof  Point);
        // System.out.println(p3.getClass().getSimpleName());


        //System.out.println("Version 1 --------");
        //System.out.println(p1.equals(p2)); // true
        //System.out.println(p2.equals(p1)); // false

        //Version 2: does not break symmetry, but breaks transitivity
        /*ColorPointV2 p1U = new ColorPointV2(100, 200, new Color(200, 0, 100));
        Point p2U = new Point(100, 200);
        ColorPointV2 p3U = new ColorPointV2(100, 200, new Color(0, 0, 0));
        System.out.println(" Version 2 -----------");
        System.out.println(p1U.equals(p2U)); // Invokes ColorPointV2's equals, compares as Points
        System.out.println(p2U.equals(p1U)); // Invokes Point's equals, compares as Points
        System.out.println(p2U.equals(p3U));  // Invokes Point's equals, compares as Points
        System.out.println(p1U.equals(p3U)); // false! so transitivity is broken
        // The last line calls ColorPointV2's equals method and compares colors too, that are different
        */

        // Version 3: preserves transitivity, but has logical issues: Point does not
        // behave as a point; breaks Liskov principle
        ColorPointV3 p1Version3 = new ColorPointV3(100, 200, new Color(200, 0, 100));
        PointV3 p2Version3 = new PointV3(100, 200);
        ColorPointV3 p3Version3 = new ColorPointV3(100, 200, new Color(0, 0, 0));
        System.out.println(" Version 3 -----------");
        System.out.println(p1Version3.equals(p2Version3));
        System.out.println(p2Version3.equals(p1Version3));
        System.out.println(p2Version3.equals(p3Version3));
        System.out.println(p1Version3.equals(p3Version3));


        // Version 4
        // Preserves symmetry, transitivity and Liskov principle (since ColorPointComposition is not
        // a subclass of Point in this version, so we don't allow them to be compared and that's okay
        /*ColorPointComposition p1Version4 = new ColorPointComposition(100, 200, new Color(200, 0, 100));
        Point p2Version4 = new Point(100, 200);
        ColorPointComposition p3Version4 = new ColorPointComposition(100, 200, new Color(0, 0, 0));
        System.out.println(" Version 4 -----------");
        System.out.println(p1Version4.equals(p2Version4));
        System.out.println(p2Version4.equals(p1Version4));
        System.out.println(p2Version4.equals(p3Version4));
        System.out.println(p1Version4.equals(p3Version4));
        */

        /*ColorPointV2 x = new ColorPointV2(100, 200, new Color(200, 0, 100));
        ColorPointV1 y = new ColorPointV1(100, 200, new Color(0, 0, 0));
        System.out.println(x.equals(y)); // false - first will call equals method of ColorPointV2, then from there version of ColorPointV1 that will return false
        System.out.println(y.equals(x)); // false - calls equals method from ColorPointV1

        System.out.println("---------");
        Point m = new ColorPointV2(100, 200, new Color(200, 0, 100));
        Point n = new ColorPointV1(100, 200, new Color(0, 0, 0));
        System.out.println(m.equals(n));
        System.out.println(n.equals(m));
        */

    }
}
