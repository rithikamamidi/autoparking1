package com.epam.autoparking;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doNothing;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
/** test class for Park class.
 * @author Rithika_Mamidi
 */
public class ParkTest {
    /** This hashmap stores the vehicle number and the
     *  slot that it is parked in.
     */
    private HashMap<String, Slot> occupiedVehicleNumberAndSlots;
    /** This arraylist stores the vacant slot numbers.
     */
    private LinkedList<Integer> vacantSlotNumbers;
    /** create mock class object.
     */
    @Mock
    private TransactionOperations mockTransac;
    /** create mock class object.
     */
    @Mock
    private FileOperations mockFileOp;
    /** inject mocks into the class.
     */
    @InjectMocks
    private Park mockPark;
    /** init method initializes all the data structures
     *  required for testing other methods.
     */
    @Before
    public void init() {
        /** This hash map stores the vehicle number and the
         *  slot that it is parked in.
         */
         occupiedVehicleNumberAndSlots = new HashMap<String, Slot>();
        /** This array list stores the vacant slot numbers.
         */
         vacantSlotNumbers = new LinkedList<Integer>();
         vacantSlotNumbers.add(2);
         Slot slot = new Slot(1, LocalTime.now());
         occupiedVehicleNumberAndSlots.put("AB12BB1234", slot);
         MockitoAnnotations.initMocks(this);
    }

    /** test method for validateCarNumber() method.
     */
    @Test
    public void testValidateCarNumber() {
        Park parkObject = new Park();
        assertTrue(parkObject.validateCarNumber("AB12BB1234"));
        assertFalse(parkObject.validateCarNumber("ab12bb1234"));
    }
    /** test method for parkCarAndStoreInTime() method.
     */
    @Test
    public void testParkCarAndStoreInTime() {
        mockTransac = spy(TransactionOperations.class);
        mockFileOp = spy(FileOperations.class);
        doNothing().when(mockTransac).append(anyString(),
               anyInt(), any(LocalTime.class));
        doNothing().when(mockFileOp).appendToFile(anyString(), anyString());
        Park parkObject = new Park();
        parkObject.parkCarAndStoreInTime("AB24BB1234", vacantSlotNumbers,
               occupiedVehicleNumberAndSlots);
        assertEquals(2, occupiedVehicleNumberAndSlots.size());
    }
    /** test method for park() method.
     */
    @Test
    public void testPark() {
        mockTransac = spy(TransactionOperations.class);
        mockFileOp = spy(FileOperations.class);
        doNothing().when(mockTransac).append(anyString(),
                anyInt(), any(LocalTime.class));
        doNothing().when(mockFileOp).appendToFile(anyString(), anyString());
        Park parkObject = new Park();
        parkObject.park("ab", vacantSlotNumbers,
                occupiedVehicleNumberAndSlots);
        parkObject.park("AB12BB1234", vacantSlotNumbers,
                occupiedVehicleNumberAndSlots);
        parkObject.park("AB38BB1234", vacantSlotNumbers,
                occupiedVehicleNumberAndSlots);
        assertEquals(2, occupiedVehicleNumberAndSlots.size());
        parkObject.park("AB39BB1234", vacantSlotNumbers,
                occupiedVehicleNumberAndSlots);
    }
}
