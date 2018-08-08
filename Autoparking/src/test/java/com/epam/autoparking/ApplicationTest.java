package com.epam.autoparking;
import static org.junit.Assert.assertEquals;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
/** this is a test class for Application class.
 * @author Rithika_Mamidi
 */
public class ApplicationTest {
    /** mocked park object.
     */
    @Mock
    private Park parkObject;
    /** This hash map stores the vehicle number and the
     *  slot that it is parked in.
     */
    private HashMap<String, Slot> occupiedVehicleNumberAndSlots;
    /** This array list stores the vacant slot numbers.
     */
    private LinkedList<Integer> vacantSlotNumbers;
    /** number of slots takes as 10 by default.
     */
    private final int numberOfSlots = 10;
    /** actual number of vacant slots.
     */
    private final int actualVacantSlots = 8;
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
         Slot slot1 = new Slot(1, LocalTime.parse("10:00:00"));
         Slot slot2 = new Slot(2, LocalTime.parse("11:00:00"));
         occupiedVehicleNumberAndSlots.put("AB12BB1234", slot1);
         occupiedVehicleNumberAndSlots.put("AB13BB1234", slot2);
    }
    /** method to test findVacantSlots() method.
     */
    @Test
    public void testFindVacantSlots() {
        Application applicationObject = new Application();
        applicationObject.findVacantSlotsFromFileReadData(vacantSlotNumbers,
                numberOfSlots, occupiedVehicleNumberAndSlots);
        assertEquals(actualVacantSlots, vacantSlotNumbers.size());
    }
    /** test method for is Admin valid method.
     */
    @Test
    public void testIsAdminValid() {
        Application applicationObject = new Application();
        Admin admin = new Admin("admin", "admin");
        assertEquals(true,
             applicationObject.isAdminValid(admin, "admin", "admin"));
        assertEquals(false, applicationObject.isAdminValid(admin,
              "admin", "admin1"));
        assertEquals(false, applicationObject.isAdminValid(admin,
                "admin1", "admin"));
    }
    /** test the main method.
     */
    @Test
    public void testMain() {
    }
}
