
package data_objects;

import utils.IValidation;
import utils.Validation;

public class DAOFactory implements IDAOFactory{

    @Override
    public IVehicleDAO vehicleDAO() {
        return new VehicleDAO();
    }

    @Override
    public IValidation validator() {
        return new Validation();
    }
    
}
