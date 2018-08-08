package com.epam.autoparking;
import java.time.LocalTime;
/** class contains the operations to be performed on the log file.
 * @author Rithika_Mamidi
 */
public class LogOperations {
    /** log file name.
     */
    private String fileName = "C:\\Users\\Rithika_Mamidi\\"
            + "eclipse-workspace\\"
            + "Autoparking\\log.csv";
    /** writes the details of the vehicle un parked form the parking lot.
     * @param carNumber vehicle number
     * @param slotNumber slot number of parking lot where
     *  the vehicle was parked.
     * @param inTime time at which the car was parked in the parking lot.
     * @param outTime time at which the car left the parking lot.
     */
    public void write(final String carNumber, final int slotNumber,
            final LocalTime inTime, final LocalTime outTime) {
              String contentToAppend = carNumber + ","
                     + String.valueOf(slotNumber) + ","
                     + inTime.toString() + ","
                     + outTime.toString();
              FileOperations fileOperationsObject = new FileOperations();
              fileOperationsObject.appendToFile(fileName, contentToAppend);
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
}
