package com.epam.autoparking;

import static org.junit.Assert.assertEquals;



import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
/** test class for UnPark class.
 * @author Rithika_Mamidi
 */
public class UnParkTest {
    /** This hash map stores the vehicle number and the
     *  slot that it is parked in.
     */
    private HashMap<String, Slot> occupiedVehicleNumberAndSlots;
    /** This array list stores the vacant slot numbers.
     */
    private LinkedList<Integer> vacantSlotNumbers;
    /** create mock class object.
     */
    @Mock
    private TransactionOperations mockTransac;
    /** inject mocks into the class.
     */
    @InjectMocks
    private UnPark mockUnPark;
    /** init method initializes all the data structures
     *  required for testing other methods.
     */
    @Before
    public void init() {
        /** This array list stores the vacant slot numbers.
         */
         vacantSlotNumbers = new LinkedList<Integer>();
        /** This hash map stores the vehicle number and the
         *  in time that it is parked at.
         */
         vacantSlotNumbers.add(2);
         occupiedVehicleNumberAndSlots = new HashMap<>();
         Slot slot = new Slot(1, LocalTime.parse("10:00:00"));
         occupiedVehicleNumberAndSlots.put("AB12BB1234", slot);
         MockitoAnnotations.initMocks(this);
    }
    /** test method for removeCarFromParking() method.
     */
    @Test
    public void testRemoveCarFromParking() {
        mockTransac = mock(TransactionOperations.class);
        doNothing().when(mockTransac).deleteRowWithVehicleNumber(anyString());
        UnPark unParkObject = new UnPark();
        unParkObject.removeCarFromParking("AB24BB1234", vacantSlotNumbers,
                occupiedVehicleNumberAndSlots);
        assertEquals(1, occupiedVehicleNumberAndSlots.size());
    }
    /** test method for unPark() method.
     */
   @Test
    public void testUnpark() {
        mockTransac = mock(TransactionOperations.class);
        doNothing().when(mockTransac).deleteRowWithVehicleNumber(anyString());
        UnPark unParkObject = new UnPark();
        unParkObject.unPark("ab", vacantSlotNumbers,
                occupiedVehicleNumberAndSlots);
        unParkObject.unPark("AB12BB1234", vacantSlotNumbers,
                occupiedVehicleNumberAndSlots);
        unParkObject.unPark("AB38BB1234", vacantSlotNumbers,
                occupiedVehicleNumberAndSlots);
        assertEquals(0, occupiedVehicleNumberAndSlots.size());
    }
    /** test method for validateCarNumber() method.
     */
    @Test
    public void testValidateCarNumber() {
        UnPark unParkObject = new UnPark();
        assertEquals(true, unParkObject.validateCarNumber("AB12BB1234"));
        assertEquals(false, unParkObject.validateCarNumber("ab12bb1234"));
    }
}
