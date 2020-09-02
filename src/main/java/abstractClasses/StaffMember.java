package abstractClasses;

/**
 * StaffMember.java       Author: Lewis/Loftus
 * Represents a generic staff member. Abstract class.
 * Has an abstract method pay() that will be overridden in concrete subclasses.
 */
abstract public class StaffMember {
   private String name;
   private String address;
   private String phone;

   /** Constructor: Sets up this staff member using the specified information.
    *
    * @param eName name
    * @param eAddress address
    * @param ePhone phone
    */
   public StaffMember(String eName, String eAddress, String ePhone) {
      this.name = eName;
      this.address = eAddress;
      this.phone = ePhone;
   }

   /** Returns a string including the basic employee information.
    *
    * @return string that contains name, address and phone
    */
   public String toString()
   {
      String result = "Name: " + this.name + System.lineSeparator();
      result += "Address: " + this.address + System.lineSeparator();
      result += "Phone: " + this.phone;

      return result;
   }

   /** Derived classes must define the pay method for each type of employee.
    *
    * @return pay
    */
   public abstract double pay();

}
