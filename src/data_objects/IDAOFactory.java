
package data_objects;

import utils.IValidation;

public interface IDAOFactory {
    IVehicleDAO vehicleDAO();
    IValidation validator();
}
