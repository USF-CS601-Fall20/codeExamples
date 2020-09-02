package abstractClasses;

/** Firm.java
 * @author Lewis/Loftus
 * Demonstrates polymorphism via inheritance.
 */
public class Firm  {
    /**  Creates a staff of employees for a firm and pays them.
     *
     * @param args command line arguments
     */
    public static void main (String[] args) {
        Staff personnel = new Staff();

        personnel.payday();

        StaffMember m = new StaffMember ("h", "b", "a") {
                @Override
                public double pay() {
                    return 1.0;
                }

        };
        m.pay();
        System.out.println(m);
    }
}
