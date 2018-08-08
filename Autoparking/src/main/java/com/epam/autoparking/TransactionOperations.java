package com.epam.autoparking;


import java.time.LocalTime;
import java.util.ArrayList;

import java.util.Map;

/** class contains all the methods to perform operations with file.
 * @author Rithika_Mamidi
 */
public class TransactionOperations {
    /** transaction file.
     */
    private String fileName =  "C:\\Users\\Rithika_Mamidi\\eclipse-workspace\\"
            + "Autoparking\\transaction.csv";
    /**stores data in transaction file.
     * @param carNumber vehicle number
     * @param slotNumber slot number of vehicle in parking lot
     * @param inTime in time of the vehicle
     */
    public void append(final String carNumber,
            final int slotNumber,
          final LocalTime inTime) {
          String contentToAppend = carNumber + "," + String.valueOf(slotNumber)
          + "," + inTime.toString();
          FileOperations fileOperationsObject = new FileOperations();
          fileOperationsObject.appendToFile(this.getFileName(),
                 contentToAppend);
    }
    /** This method reads data from csv file and stores it in hash map.
     * @param occupiedVehicleNumberAndSlots vehicle number-slot number
     * and in time
     */
    public void readData(final Map<String, Slot>
            occupiedVehicleNumberAndSlots) {
        ArrayList<String[]> contentRead;
        FileOperations fileOperationsObject = getFileOperationsObject();
        contentRead = fileOperationsObject.readDataFromFile(this.getFileName());
        for (String[] dataRow : contentRead) {
            Slot slot = new Slot(Integer.parseInt(dataRow[1]),
                   LocalTime.parse(dataRow[2]));
            occupiedVehicleNumberAndSlots.put(dataRow[0], slot);
        }
    }
    /** This method deletes the row corresponding to the vehicle
     *  number which is un parked.
     * @param carNumber vehicle number of the un parked vehicle.
     */
    public void deleteRowWithVehicleNumber(final String carNumber) {
        FileOperations fileOperationsObject = getFileOperationsObject();
        fileOperationsObject.deleteRowFromFile(this.getFileName(), carNumber);
    }
    /** returns the filename.
     * @return file name
     */
    public String getFileName() {
       return fileName;
    }
    /** set the file name of the object.
     * @param fileName1 file name to be set.
     */
    public void setFileName(final String fileName1) {
        this.fileName = fileName1;
    }
    /** returns new object for file operations class.
     * @return new file operations class object
     */
    public FileOperations getFileOperationsObject() {
        return new FileOperations();
    }
}
