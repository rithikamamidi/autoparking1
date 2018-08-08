package com.epam.autoparking;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
/** Test the class Validate.
 * @author Rithika_Mamidi
 */
public class ValidationTest {
    /** Unit test cases for validateVehicleNumber method.
     */
    @Test
    public void testValidateVehicleNumber() {
        Validation validate = new Validation();
        assertTrue(validate.validateVehicleNumber("AB12BB1234"));
        assertTrue(validate.validateVehicleNumber("AB12B1234"));
        assertFalse(validate.validateVehicleNumber("A1234"));
    }
}
