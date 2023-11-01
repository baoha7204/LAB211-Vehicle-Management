
package utils;

import business_objects.VehicleType;
import java.util.Date;

public interface IValidation {
    
    String checkString(String msg, Status status);
    
    String checkStringRegex(String msg, String regex, Status status);
    
    int checkInt(String msg, int min, int max, Status status);

    double checkDouble(String msg, double min, double max, Status status);

    boolean checkYesOrNo(String msg);
    
    Date checkBeforeDate(String msg, Status status);

    Date checkAfterDate(String msg, Date productionDate, Status status);
    
    VehicleType checkVehicleType(String msg, Status status);

}
