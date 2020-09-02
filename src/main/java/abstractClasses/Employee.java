package abstractClasses;
/**  Employee.java       Author: Lewis/Loftus
 * Represents a general paid employee.
 */
public class Employee extends StaffMember
{
   private String socialSecurityNumber;
   private double payRate;

   /** Constructor: Sets up this employee with the specified information.
    *
    * @param eName name
    * @param eAddress address
    * @param ePhone phone
    * @param socSecNumber social security number
    * @param rate pay rate
    */
   public Employee(String eName, String eAddress, String ePhone,
                   String socSecNumber, double rate) {
      super(eName, eAddress, ePhone);

      socialSecurityNumber = socSecNumber;
      payRate = rate;
   }

   /** A getter method for payRate - will be used in Hourly
    *
    * @return pay rate
    */
   public double getPayRate() {
      return payRate;
   }

   /** Returns information about an employee as a string.
    *
    * @return String representation of employee
    */
   public String toString() {
      String result = super.toString();

      result += System.lineSeparator() + "Social Security Number: " + socialSecurityNumber;

      return result;
   }

   /** Returns the pay rate for this employee.
    *
    * @return pay rate
    */
   public double pay()
   {
      return payRate;
   }


}
