package com.epam.autoparking;

import java.time.LocalTime;
/** has the slot details.
 * @author Rithika_Mamidi
 */
public class Slot {
    /** slot number.
     */
    private int slotNumber;
    /** in time of the vehicle.
     */
    private LocalTime inTime;
    /** constructor of Slot.
     * @param slotNumber1 slot number
     * @param inTime1 in time of the vehicle
     */
    Slot(final int slotNumber1, final LocalTime inTime1) {
        this.slotNumber = slotNumber1;
        this.inTime = inTime1;
    }
    /** get the slot number.
     * @return slot number.
     */
    public int getSlotNumber() {
        return slotNumber;
    }
    /** get in time of the vehicle.
     * @return in time of vehicle.
     */
    public LocalTime getInTime() {
        return inTime;
    }
    /** set slot number.
     * @param slotNumber1 slot number
     */
    public void setSlotNumber(final int slotNumber1) {
        this.slotNumber = slotNumber1;
    }
    /** set in time of the vehicle.
     * @param inTime1 in time of the vehicle.
     */
    public void setInTime(final LocalTime inTime1) {
        this.inTime = inTime1;
    }
}
