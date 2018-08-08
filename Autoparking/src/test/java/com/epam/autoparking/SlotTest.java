package com.epam.autoparking;

import static org.junit.Assert.assertEquals;


import java.time.LocalTime;

import org.junit.Test;
/** test class for Slot class.
 * @author Rithika_Mamidi
 */
public class SlotTest {
    /** test the set slot number method.
     */
    @Test
    public void testSetSlotNumber() {
        Slot slot = new Slot(2, LocalTime.parse("10:00:00"));
        slot.setSlotNumber(1);
        assertEquals(1, slot.getSlotNumber());
    }
    /** test set in time method.
     */
    @Test
    public void testSetInTime() {
        Slot slot = new Slot(2, LocalTime.parse("10:00:00"));
        slot.setInTime(LocalTime.parse("11:00:00"));
        assertEquals(LocalTime.parse("11:00:00"), slot.getInTime());
    }
    /** tests get slot number method.
     */
    @Test
    public void testGetSlotNumber() {
        Slot slot = new Slot(2, LocalTime.parse("10:00:00"));
        assertEquals(2, slot.getSlotNumber());
    }
    /** tests get in time method.
     */
    @Test
    public void testGetInTime() {
        Slot slot = new Slot(2, LocalTime.parse("10:00:00"));
        assertEquals(LocalTime.parse("10:00:00"), slot.getInTime());
    }


}
