package com.epam.autoparking;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/** Test the class Admin.
 * @author Rithika_Mamidi
 */
public class AdminTest {
    /** Unit test cases to test the getUserName method.
     */
    @Test
    public void testGetUserName() {
        Admin admin = new Admin("admin", "admin");
        assertEquals("admin", admin.getUserName());
    }
    /** Unit test cases to test the getPassword method.
     */
    @Test
    public void testGetPassword() {
        Admin admin = new Admin("admin", "password");
        assertEquals("password", admin.getPassword());
    }
    /** Unit test cases to test the setPassword method.
     */
    @Test
    public void testSetPassword() {
        Admin admin = new Admin();
        admin.setPassword("stringPassword");
        assertEquals("stringPassword", admin.getPassword());
    }
    /** Unit test cases to test the setUserName method.
     */
    @Test
    public void testSetUserName() {
        Admin admin = new Admin();
        admin.setUserName("stringUserName");
        assertEquals("stringUserName", admin.getUserName());
    }
}
