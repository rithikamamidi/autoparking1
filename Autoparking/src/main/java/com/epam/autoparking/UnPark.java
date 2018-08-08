package com.epam.autoparking;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
/** class contains all the methods required to perform un parking of a vehicle.
 * @author Rithika_Mamidi
 */
public class UnPark {
    /** This method deals with the functionality when the vehicle is unparked.
     * @param carNumber vehicle number of the vehicle
     * @param vacantSlotNumbers vacant slot numbers
     * @param occupiedVehicleNumberAndSlots vehicle number-slot number-inTime*/
     public void unPark(final String carNumber,
            final List<Integer> vacantSlotNumbers,
            final Map<String, Slot> occupiedVehicleNumberAndSlots) {
        if (occupiedVehicleNumberAndSlots.isEmpty()) {
            System.out.println("Parking lot is vacant!");
        } else {
            if (validateCarNumber(carNumber)) {
                removeCarFromParking(carNumber, vacantSlotNumbers,
                        occupiedVehicleNumberAndSlots);
            } else {
                System.out.println("Invalid car number");
            }
        }
    }
    /** This method updates all the data associated with the vehicle,
     * when it is un parked.
     * @param carNumber **vehicleNumber that has to be un parked**
     * @param vacantSlotNumbers **vacant slot numbers**
     * @param occupiedVehicleNumberAndSlots **vehicle number-slot number***/
    public void removeCarFromParking(final String carNumber,
            final List<Integer> vacantSlotNumbers,
            final Map<String, Slot> occupiedVehicleNumberAndSlots) {
        if (occupiedVehicleNumberAndSlots.containsKey(carNumber)) {
            Slot slot = occupiedVehicleNumberAndSlots.
                    remove(carNumber);
            vacantSlotNumbers.add(slot.getSlotNumber());
            findTimeForWhichCarIsParked(carNumber, slot.getSlotNumber(),
                   slot.getInTime());
            TransactionOperations transactionFileOperations =
                    new TransactionOperations();
            transactionFileOperations.deleteRowWithVehicleNumber(carNumber);
            System.out.println("Vehicle unparked successfully !");
        } else {
            System.out.println("car doesn't exist in parking lot!");
        }
    }
    /** This method finds the time for which the car is parked
     *  in the parking lot.
     * @param carNumber vehicle number of the car
     * @param inTime  in time
     * @param vacantSlot slot number of parking lot occupied by vehicle */
    public void findTimeForWhichCarIsParked(final String carNumber,
                  final int vacantSlot,
                  final LocalTime inTime) {
        LocalTime nowTime = LocalTime.now();
        int hoursDifference = (int) ChronoUnit.HOURS.between(inTime, nowTime);
        int minutesDifference = (int) ChronoUnit.MINUTES.
                between(inTime, nowTime);
        int secondsDifference = (int) ChronoUnit.SECONDS.
                between(inTime, nowTime);
        System.out.printf("The vehicle was parked for time:%d hours,"
                + " %d minutes, %d seconds\n",
                hoursDifference, minutesDifference,
                secondsDifference);
        LogOperations logFileOperations = new LogOperations();
        logFileOperations.write(carNumber, vacantSlot, inTime, nowTime);
        }
    /** This method validates the car number entered by the user.
     * @param vehicleNumber  Vehicle number entered
     * @return true if vehicle number is valid, else returns false. */
    public boolean validateCarNumber(final String vehicleNumber) {
       Validation validater = new Validation();
       return validater.validateVehicleNumber(vehicleNumber);
   }

}
