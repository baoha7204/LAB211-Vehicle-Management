
package data_objects;

import business_objects.Vehicle;
import java.util.ArrayList;
import java.util.List;
import utils.HandlingFile;

public class VehicleDAO implements IVehicleDAO{
    private final String VEHICLE_FILEPATH = "vehicle.dat";
    List<Vehicle> vehicleList;

    public VehicleDAO() {
        vehicleList = new ArrayList<>();
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        return vehicleList.add(vehicle);
    }

    @Override
    public Vehicle getVehicleById(String id) {
        for(Vehicle vehicle: vehicleList){
            if(vehicle.getID_Vehicle().equals(id)){
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public Vehicle getVehicleByName(String name) {
        for(Vehicle vehicle: vehicleList){
            if(vehicle.getName_Vehicle().equalsIgnoreCase(name)){
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> tempList = new ArrayList<>();
        tempList.addAll(vehicleList);
        return tempList;
    }

    @Override
    public List<Vehicle> getByPrice(double price) {
        List<Vehicle> tempList = new ArrayList<>();
        for(Vehicle vehicle: vehicleList){
            if(vehicle.getPrice() < price){
                tempList.add(vehicle);
            }
        }
        return tempList;
    }
    
    @Override
    public List<Vehicle> getByYear(int year) {
        List<Vehicle> tempList = new ArrayList<>();
        for(Vehicle vehicle: vehicleList){
            if(vehicle.getProductYear() >= year){
                tempList.add(vehicle);
            }
        }
        return tempList;
    }

    @Override
    public boolean deleteVehicle(Vehicle vehicle) {
        return vehicleList.remove(vehicle);
    }

    @Override
    public boolean isVehicleIdExist(String id) {
        for(Vehicle vehicle: vehicleList){
            if(vehicle.getID_Vehicle().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean saveToFile() {
        return new HandlingFile<Vehicle>().saveToFile(VEHICLE_FILEPATH, vehicleList);
    }

    @Override
    public boolean loadFromFile() {
        return new HandlingFile<Vehicle>().loadFromFile(VEHICLE_FILEPATH, vehicleList);
    }

    @Override
    public List<Vehicle> getByName(String name) {
        List<Vehicle> tempList = new ArrayList<>();
        for(Vehicle vehicle: vehicleList){
            if(vehicle.getName_Vehicle().toUpperCase().contains(name.toUpperCase())){
                tempList.add(vehicle);
            }
        }
        return tempList;
    } 
}