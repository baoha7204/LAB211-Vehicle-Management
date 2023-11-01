
package data_objects;

import business_objects.Vehicle;
import java.util.List;

public interface IVehicleDAO {
    boolean addVehicle(Vehicle vehicle);
    Vehicle getVehicleById(String id);
    Vehicle getVehicleByName(String name);
    List<Vehicle> getAll();
    List<Vehicle> getByPrice(double price);
    List<Vehicle> getByYear(int year);
    List<Vehicle> getByName(String name);
    boolean deleteVehicle(Vehicle vehicle);
    boolean isVehicleIdExist(String id);
    // handling file
    boolean saveToFile();
    boolean loadFromFile();
}
