
package action_service;

import business_objects.Vehicle;
import java.util.List;

public interface IService {
    // Vehicle repository
    String inputVehicleId(boolean checkExisted);
    void addVehicle();
    void checkExistVehicle();
    void updateVehicle();
    void deleteVehicle();
    void searchVehicleByName();
    void searchVehicleById();
    void showVehicleList(List<Vehicle> list);
    void showAllVehicles();
    void showByPriceVehicles();
    void showByYearVehicles();
    void saveAll();
    void loadAll();
}
