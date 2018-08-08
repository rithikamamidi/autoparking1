package com.epam.autoparking;
/** The class Admin is a skeleton for the admin details.
 * @author Rithika_Mamidi
 */
public class Admin {
     /** The string userName stores the user name of admin.
     * The string password stores the password of admin.
     */
    private String userName, password;
    /** This is an empty constructor.
     */
    public Admin() {
    }
    /** This is a constructor to initialize the values of an admin.
     * @param userName1 **user name of admin**
     * @param password1 **password of admin**
     */
     public Admin(final String userName1, final String password1) {
        this.userName = userName1;
        this.password = password1;
    }
    /** This method returns the user name of admin.
     * @return **user name of admin**
     */
    public String getUserName() {
        return userName;
    }
    /** This method returns the password of admin.
     * @return **password of admin**
     */
    public String getPassword() {
        return password;
    }
    /** This method sets the user name of admin.
     * @param userName1 **This is user name of admin**
     */
    public void setUserName(final String userName1) {
        this.userName = userName1;
    }
    /** This method sets the password of the admin.
     * @param password1 **This is password of admin**
     */
     public void setPassword(final String password1) {
       this.password = password1;
    }
}
