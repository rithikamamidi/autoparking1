package com.epam.autoparking;



import java.time.LocalTime;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
/** test class for log file operations class.
 * @author Rithika_Mamidi
 */
public class LogOperationsTest {
    /** object for Log file operations.
     */
    private LogOperations logObject =
            new LogOperations();
    /** initialize all the variables needed for testing.
     */
    @Before
    public void init() {
        String fileNameForTest = "C:\\Users\\Rithika_Mamidi\\"
                + "eclipse-workspace\\Autoparking\\testlog.csv";
        logObject.setFileName(fileNameForTest);
    }
    /**test write method.
     */
    @Test
    public void testWrite() {
        logObject.write("AB15BB1234", 1, LocalTime.parse("12:00:00"),
                 LocalTime.parse("12:30:00"));
        FileOperations fileOperationsObject = new FileOperations();
        ArrayList<String[]> readData = new ArrayList<>();
        TransactionOperations transactionObject =
                new TransactionOperations();
        readData = fileOperationsObject.readDataFromFile(
                logObject.getFileName());
    }

}
