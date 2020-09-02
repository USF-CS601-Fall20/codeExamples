package abstractClasses;

/** Staff.java
 * Author: Lewis/Loftus
 * Represents the personnel staff of a particular company. */
public class Staff {
    private StaffMember[] staffList;

    /** Constructor: Sets up the list of staff members.*/
    public Staff() {
        staffList = new StaffMember[6];

        staffList[0] = new Executive("Sami", "123 Main Line",
                "555-0469", "123-45-6789", 2423.07);

        staffList[1] = new Employee("Carla", "456 Off Line",
                "555-0101", "987-65-4321", 1246.15);
        staffList[2] = new Employee("Woody", "789 Off Rocker",
                "555-0000", "010-20-3040", 1169.23);

        staffList[3] = new Hourly("Diane", "678 Fifth Ave.",
                "555-0690", "958-47-3625", 10.55);

        staffList[4] = new Volunteer("Norm", "987 Suds Blvd.",
                "555-8374");
        staffList[5] = new Volunteer("Cliff", "321 Duds Lane",
                "555-7282");

        StaffMember m = new Employee("Carla", "456 Off Line",
                "555-0101", "987-65-4321", 1246.15);

        ((Executive)staffList[0]).awardBonus(500.00);

        ((Hourly)staffList[3]).addHours(40);

        // Note: could have also used an initializer list:
        // Java would automatically upcast each to StaffMember type:
        //StaffMember[] otherStaff = {new Hourly("Diane", "678 Fifth Ave.",
          //      "555-0690", "958-47-3625", 10.55),
            //    new Volunteer("Chris", "CS Labs.",
              //  "415-4226777")};

    }

    /** Pays all staff members. */
    public void payday () {
        double amount;

        for (int count=0; count < staffList.length; count++) {
            System.out.println(staffList[count]);

            amount = staffList[count].pay();  // polymorphic

            if (amount == 0.0)
                System.out.println("Thanks!");
            else
                System.out.println("Paid: " + amount);

            System.out.println("-----------------------------------");
        }
    }
}
