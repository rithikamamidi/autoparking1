package com.epam.autoparking;

import static org.junit.Assert.assertEquals;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
/** tests transaction file operations class.
 * @author Rithika_Mamidi
 */
@RunWith(MockitoJUnitRunner.class)
public class TransactionOperationsTest {
    /** object for transaction file operations.
     */
    private TransactionOperations transactionObject =
            new TransactionOperations();
    /** vehicle number - slot number.
     */
    private Map<String, Slot> occupiedVehicleNumberAndSlots;
    /** create mock class object.
     */
    @Mock
    private FileOperations mockFileOp;
    /** inject mocks into the class.
     */
    @InjectMocks
    private TransactionOperations mockTransac;
    /** initialize all the variables needed for testing.
     */
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        String fileNameForTest = "C:\\Users\\Rithika_Mamidi\\"
                + "eclipse-workspace\\Autoparking\\test.csv";
        transactionObject.setFileName(fileNameForTest);
        occupiedVehicleNumberAndSlots =  new HashMap<>();
    }
    /** test read data method.
     */
    @Test
    public void testReadData() {
        ArrayList<String[]> contentRead1 = new ArrayList<String[]>();
        String[] data = {"AP09BB1234", "2", "10:00:00"};
        contentRead1.add(data);
        mockFileOp = mock(FileOperations.class);
        Mockito.doReturn(contentRead1).when(mockFileOp).
              readDataFromFile(anyString());
        transactionObject.readData(occupiedVehicleNumberAndSlots);
        assertEquals(1, occupiedVehicleNumberAndSlots.size());
    }
    /** tests append method.
     */
    @Test
    public void testAppend() {
        mockFileOp = spy(FileOperations.class);
        doNothing().when(mockFileOp).appendToFile(anyString(), anyString());
        transactionObject.append("abc", 2, LocalTime.parse("10:00:00"));
        verify(mockFileOp, never()).appendToFile(anyString(), anyString());
    }
    /** tests delete a row method.
     */
    @Test
    public void testDeleteRowWithVehicleNumber() {
        mockFileOp = mock(FileOperations.class);
        doNothing().when(mockFileOp).deleteRowFromFile(anyString(),
                anyString());
        transactionObject.deleteRowWithVehicleNumber("AB12BB1234");
        verify(mockFileOp, never()).deleteRowFromFile(anyString(), anyString());
    }

}
