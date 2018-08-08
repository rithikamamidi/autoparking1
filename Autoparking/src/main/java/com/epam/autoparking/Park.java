package com.epam.autoparking;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/** class contains all the methods required to park a vehicle.
 * @author Rithika_Mamidi
 */
public class Park {
    /** This method deals with the functionality when the vehicle is parked.
     * @param carNumber vehicle number of the vehicle
     * @param vacantSlotNumbers vacant slot numbers
     * @param occupiedVehicleNumberAndSlots vehicle number-slot number- inTime*/
     public void park(final String carNumber,
            final List<Integer> vacantSlotNumbers,
            final Map<String, Slot> occupiedVehicleNumberAndSlots) {
        if (vacantSlotNumbers.isEmpty()) {
            System.out.println("Parking lot is full !");
        } else {
            if (validateCarNumber(carNumber)) {
                parkCarAndStoreInTime(carNumber, vacantSlotNumbers,
                       occupiedVehicleNumberAndSlots);
            } else {
                System.out.println("Invalid car number!");
            }
        }
    }
     /** This method updates the data associated with
      *  the vehicle when it is parked.
      * @param carNumber  vehicle number to be parked
      * @param vacantSlotNumbers vacant slot numbers
      * @param occupiedVehicleNumberAndSlots vehicle number-slot number-intime*/
     public void parkCarAndStoreInTime(final String carNumber,
             final List<Integer> vacantSlotNumbers,
             final Map<String, Slot> occupiedVehicleNumberAndSlots) {
         if (!occupiedVehicleNumberAndSlots.containsKey(carNumber)) {
             int slotNumber = ((LinkedList<Integer>) vacantSlotNumbers).
                    removeFirst();
             LocalTime inTime = LocalTime.now();
             Slot slot = new Slot(slotNumber, inTime);
             occupiedVehicleNumberAndSlots.put(carNumber, slot);
             TransactionOperations transactionFileOperations =
                     getTransactionOperationsObject();
             transactionFileOperations.append(carNumber, slotNumber, inTime);
             System.out.println("car parked successfully !");
         } else {
             System.out.println("Car is already in the parking lot!");
         }
     }
     /** This method validates the car number entered by the user.
      * @param vehicleNumber  Vehicle number entered
      * @return true if vehicle number is valid, else returns false. */
    public boolean validateCarNumber(final String vehicleNumber) {
        Validation validater = new Validation();
        return validater.validateVehicleNumber(vehicleNumber);
    }
    /** returns new Transaction operations object.
     * @return transaction file operations object.
     */
    public TransactionOperations getTransactionOperationsObject() {
       return new TransactionOperations();
    }


}
