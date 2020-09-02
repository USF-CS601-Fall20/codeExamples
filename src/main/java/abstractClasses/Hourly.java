package abstractClasses;

/** Hourly.java
 * @author: Lewis/Loftus
 * Represents an employee that gets paid by the hour.
 */
public class Hourly extends Employee {
   private int hoursWorked;
   // payRate for the Hourly Employee is the pay rate per hour

   /** Constructor: Sets up this hourly employee using the specified information.
    *
    * @param eName name
    * @param eAddress address
    * @param ePhone phone
    * @param socSecNumber social security number
    * @param rate rate
    */
   public Hourly(String eName, String eAddress, String ePhone,
                 String socSecNumber, double rate) {
      super(eName, eAddress, ePhone, socSecNumber, rate);

      hoursWorked = 0;
   }

   /** Adds the specified number of hours to this employee's accumulated hours.
    *
    * @param moreHours additional hours that employee worked
    */
   public void addHours(int moreHours)
   {
      hoursWorked += moreHours;
   }

   /** Computes and returns the pay for this hourly employee.
    *
    * @return pay
    */
   @Override
   public double pay() {
      double payment = getPayRate() * hoursWorked;

      hoursWorked = 0;

      return payment;
   }

   /** Returns information about this hourly employee as a string.
    *
    * @return String representation
    */
   public String toString() {
      String result = super.toString();

      result += System.lineSeparator() + "Current hours: " + hoursWorked;

      return result;
   }
}
