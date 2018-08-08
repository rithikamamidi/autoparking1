package com.epam.autoparking;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**This class contains all the validations for the
 *  input to be read from the user.
 * @author Rithika_Mamidi
 */
public class Validation {
    /**This is an empty constructor.
     */
    public Validation() {
    }
 /**This method validates the vehicle number
  *  that has to be read from the user.
  * @param vehicleNumber **The vehicle number that is to be validated**
  * @return **The status of validation,
  *if valid returns true else returns false**
  */
    public boolean validateVehicleNumber(final String vehicleNumber) {
        String regExForVehicleNumber =
                "^[A-Z]+{2}[0-9]+{2}[A-Z]+{1,2}[0-9]+{4}$";
        Pattern vehicleNumberPattern =
                 Pattern.compile(regExForVehicleNumber);
        Matcher matcher = vehicleNumberPattern.matcher(vehicleNumber);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
