package abstractClasses;
/** Class Volunteer
 *  Author: Lewis/Loftus
 *  Represents a staff member that works as a volunteer.
 */
public class Volunteer extends StaffMember {

   /** Constructor: Sets up this volunteer using the specified information.
    *
    * @param eName name
    * @param eAddress address
    * @param ePhone phone
    */
   public Volunteer(String eName, String eAddress, String ePhone) {
      super(eName, eAddress, ePhone);
   }

   /**  Returns a zero pay value for this volunteer.
    *
    * @return monthly pay (for volunteer it is a zero)
    */
   @Override
   public double pay() {
      return 0.0;
   }
}
