package com.epam.autoparking;

import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**The auto parking application.
 * @author Rithika_Mamidi
 */
public class Application {
    /** This main method deals with reading data and acting accordingly.
     * @param args Stores the data the user gives through command line. */
    public static void main(final String[] args) {
        /** Scanner object to read data from console. */
        Scanner scannerObj = new Scanner(System.in);
        /** This hash map stores the vehicle number and the
         *  slot that it is parked in. */
        Map<String, Slot> occupiedVehicleNumberAndSlots =
                   new HashMap<>();
        /** This array list stores the vacant slot numbers.  */
        List<Integer> vacantSlotNumbers
                             = new LinkedList<>();
        int choice;
        int next = 1;
        String carNumber;
        final int ten = 10;
        final int three = 3;
        int numberOfSlots = ten;
        Admin admin = new Admin("admin", "admin");
        Application app = new Application();
        TransactionOperations transactionFileOperations =
                new TransactionOperations();
        String userName = args[0];
        String password = args[1];
        if (app.isAdminValid(admin, userName, password)) {
            System.out.println("Welcome admin! ");
            int loadFromFile = Integer.parseInt(args[2]);
            if (loadFromFile == 1) {
                numberOfSlots = Integer.parseInt(args[three]);
                for (int i = 0; i < numberOfSlots; i++) {
                    vacantSlotNumbers.add(i + 1);
                }
            } else {
                transactionFileOperations.readData(
                        occupiedVehicleNumberAndSlots);
                app.findVacantSlotsFromFileReadData(vacantSlotNumbers,
                        numberOfSlots,
                    occupiedVehicleNumberAndSlots);
            }
            Park parkObject = new Park();
            UnPark unParkObject = new UnPark();
            while (next == 1) {
                System.out.println("1.Park vehicle\n"
                        + "2.Unpark vehicle");
                System.out.println("Enter your choice:");
                try {
                choice = scannerObj.nextInt();
                switch (choice) {
                case 1:System.out.println("Enter car number:");
                      carNumber = scannerObj.next();
                     parkObject.park(carNumber, vacantSlotNumbers,
                        occupiedVehicleNumberAndSlots);
                break;
                case 2:System.out.println("Enter car number:");
                      carNumber = scannerObj.next();
                    unParkObject.unPark(carNumber, vacantSlotNumbers,
                        occupiedVehicleNumberAndSlots);
                break;
                default:System.out.println("Enter valid"
                        + " choice!");
                break;
                }
                System.out.println("If you want to repeat the "
                        + "process above again"
                        + " press 1 else press 0");
                    next = scannerObj.nextInt();
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Invalid entry!");
                    scannerObj.nextLine();
                }
             }
         } else {
            System.out.println("Invalid credentials !");
         }
    }
    /** This method finds the vacant slots in the parking lot.
     * @param vacantSlotNumbers slot numbers of vacant slots in the parking lot.
     * @param numberOfSlots number of slots in the parking lot.
     * @param occupiedVehicleNumberAndSlots vehicle number - slot number
     */
    public void findVacantSlotsFromFileReadData(
             final List<Integer> vacantSlotNumbers,
             final int numberOfSlots, final Map<String,
             Slot> occupiedVehicleNumberAndSlots) {
        int[] slotNumbers = new int[numberOfSlots];
        for (int index = 0; index < numberOfSlots; index++) {
            slotNumbers[index] = 0;
        }
        Collection<Slot> slotValues = occupiedVehicleNumberAndSlots.values();
        for (Slot slot : slotValues) {
            slotNumbers[(slot.getSlotNumber()) - 1] = 1;
        }
        for (int index = 0; index < numberOfSlots; index++) {
            if (slotNumbers[index] == 0) {
                vacantSlotNumbers.add(index + 1);
            }
        }
    }
    /** validates admin.
     * @param admin credentials of valid admin
     * @param userName user name of entered user
     * @param password password of entered user.
     * @return is valid or no
     */
    public boolean isAdminValid(final Admin admin, final String userName,
            final String password) {
        boolean isValid = false;
        if (userName.equals(admin.getUserName())
        && password.equals(admin.getPassword())) {
           isValid = true;
        }
        return isValid;
    }
}
