package action_service;

import business_objects.Vehicle;
import business_objects.VehicleType;
import data_objects.DAOFactory;
import data_objects.IDAOFactory;
import data_objects.IVehicleDAO;
import java.util.Collections;
import java.util.List;
import utils.IValidation;
import utils.Status;

public class Service implements IService {

    private IDAOFactory factoryDAO = new DAOFactory();
    public IValidation validator = factoryDAO.validator();
    private IVehicleDAO vehicleDAO = factoryDAO.vehicleDAO();

    @Override
    public String inputVehicleId(boolean existedRestriction) {
        String vehicleId;
        while (true) {
            vehicleId = validator.checkStringRegex("Input ID (Vxyzt, with x, y, z, t are number): ", Vehicle.regex, Status.NORMAL);
            boolean isIdExist = vehicleDAO.isVehicleIdExist(vehicleId);

            if (existedRestriction) {
                if (!isIdExist) {
                    System.err.println("This vehicle hasn't existed. Please input another id");
                    continue;
                }
            } else {
                if (isIdExist) {
                    System.err.println("This vehicle has existed. Please input another id");
                    continue;
                }
            }
            break;
        }
        return vehicleId;
    }

    @Override
    public void addVehicle() {
        do {
            // Input non existed Id
            String id = inputVehicleId(false);
            // Input another vehicle
            String name = validator.checkString("Input name: ", Status.NORMAL);
            String color = validator.checkString("Input color: ", Status.NORMAL);
            double price = validator.checkDouble("Input price: ", 0, Double.MAX_VALUE, Status.NORMAL);
            String brand = validator.checkString("Input brand: ", Status.NORMAL);
            VehicleType type = validator.checkVehicleType("Input type: ", Status.NORMAL);
            int yearProduct = validator.checkInt("Input year product: ", 1900, 2099, Status.NORMAL);
            Vehicle addedVehicle = new Vehicle(id, name, color, price, brand, type, yearProduct);
            // Throw error or successful message
            if (vehicleDAO.addVehicle(addedVehicle)) {
                System.out.println("Add succesfully!");
            } else {
                System.err.println("Some error has occured. Please check again!");
            }
        } while (validator.checkYesOrNo("Add more (Y/N)? "));
    }

    @Override
    public void checkExistVehicle() {
        // Input id with regex
        String id = validator.checkStringRegex("Input ID (Vxyzt, with x, y, z, t are number): ", Vehicle.regex, Status.NORMAL);
        // Throw error or successful message
        if (vehicleDAO.isVehicleIdExist(id)) {
            System.out.println("Vehicle " + id + " is existed!");
        } else {
            System.err.println("Vehicle " + id + " is NOT FOUND!");
        }
    }

    @Override
    public void updateVehicle() {
        // Input non existed Id
        String id = inputVehicleId(true);
        Vehicle updatedVehicle = vehicleDAO.getVehicleById(id);
        // Update vehicle
        String name = validator.checkString("Input name: ", Status.UPDATE);
        if (updatedVehicle.setName_Vehicle(name)) {
            System.out.println("Successfully changed to: " + name);
        }

        String color = validator.checkString("Input color: ", Status.UPDATE);
        if (updatedVehicle.setColor_Vehicle(color)) {
            System.out.println("Successfully changed to: " + color);
        }

        double price = validator.checkDouble("Input price: ", 0, Double.MAX_VALUE, Status.UPDATE);
        if (updatedVehicle.setPrice(price)) {
            System.out.println("Successfully changed to: " + price);
        }

        String brand = validator.checkString("Input brand: ", Status.UPDATE);
        if (updatedVehicle.setBrand_Vehicle(brand)) {
            System.out.println("Successfully changed to: " + brand);
        }

        VehicleType type = validator.checkVehicleType("Input type: ", Status.UPDATE);
        if (updatedVehicle.setType(type)) {
            System.out.println("Successfully changed to: " + type);
        }

        int yearProduct = validator.checkInt("Input year product: ", 1900, 2099, Status.UPDATE);
        if (updatedVehicle.setProductYear(yearProduct)) {
            System.out.println("Successfully changed to: " + yearProduct);
        }

        System.out.println("Successfully update vehicle: " + updatedVehicle);
    }

    @Override
    public void deleteVehicle() {
        String vehicleId = inputVehicleId(true);
        if (validator.checkYesOrNo("Confirm delete (Y/N)?")) {
            Vehicle deletedVehicle = vehicleDAO.getVehicleById(vehicleId);
            if (vehicleDAO.deleteVehicle(deletedVehicle)) {
                System.out.println("Successfully delete!");
            } else {
                System.err.println("Fail to delete! Please try again.");
            }
        }
    }

    @Override
    public void searchVehicleByName() {
        String searchingName = validator.checkString("Input searching name: ", Status.NORMAL);
        List<Vehicle> searchingList = vehicleDAO.getByName(searchingName);
            if (searchingList.isEmpty()) {
            System.out.println("Searching list is empty!");
            return;
        }
        Collections.sort(searchingList, Vehicle.compareNameDesc);
        showVehicleList(searchingList);
    }

    @Override
    public void searchVehicleById() {
        // Input id with regex
        String searchingId = validator.checkStringRegex("Input searching ID (Vxyzt, with x, y, z, t are number): ", Vehicle.regex, Status.NORMAL);
        Vehicle searchingVehicle = vehicleDAO.getVehicleById(searchingId);
        if (searchingVehicle == null) {
            System.out.println("Vehicle may not exist! Please input another ID.");
            return;
        }
        System.out.println(searchingVehicle);
    }

    @Override
    public void showAllVehicles() {
        showVehicleList(vehicleDAO.getAll());
    }

    @Override
    public void showByPriceVehicles() {
        double searchingPrice = validator.checkDouble("Input searching price: ", 0, Double.MAX_VALUE, Status.NORMAL);
        List<Vehicle> searchingList = vehicleDAO.getByPrice(searchingPrice);
        if (searchingList.isEmpty()) {
            System.out.println("Searching list is empty!");
            return;
        }
        Collections.sort(searchingList, Vehicle.comparePriceDesc);
        showVehicleList(searchingList);
    }

    @Override
    public void showByYearVehicles() {
        int searchingYear = validator.checkInt("Input year product: ", 1900, 2099, Status.NORMAL);
        List<Vehicle> searchingList = vehicleDAO.getByYear(searchingYear);
        if (searchingList.isEmpty()) {
            System.out.println("Searching list is empty!");
            return;
        }
        Collections.sort(searchingList, Vehicle.compareYearDesc);
        showVehicleList(searchingList);
    }

    @Override
    public void saveAll() {
        if (vehicleDAO.saveToFile()) {
            System.out.println("Saving vehicles to database successfully!");
        } else {
            System.err.println("An error has occured during saving vehicles! Please try again!");
        }
    }

    @Override
    public void loadAll() {
        vehicleDAO.loadFromFile();
    }

    @Override
    public void showVehicleList(List<Vehicle> list) {
        for (Vehicle vehicle : list) {
            System.out.println(vehicle);
        }
    }
}
