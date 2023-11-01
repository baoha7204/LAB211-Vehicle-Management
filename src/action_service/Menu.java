
package action_service;

import utils.Status;

public class Menu {
    static final Service service = new Service();
    
    public static void mainMenu() {
        service.loadAll();
        int choice;
        do {
            System.out.println("---MAIN MENU---\n"
                    + "1. Add new vehicle\n"
                    + "2. Check exits vehicle\n"
                    + "3. Update vehicle\n"
                    + "4. Delete vehicle\n"
                    + "5. Search vehicle\n"
                    + "6. Display vehicle list\n"
                    + "7. Save all vehicles to file\n"
                    + "8. Print vehicle list\n"
                    + "9. Close the application");
            choice = service.validator.checkInt("Input the choice:", 1, 9, Status.NORMAL);
            switch (choice) {
                case 1:
                    service.addVehicle();
                    break;
                case 2:
                    service.checkExistVehicle();
                    break;
                case 3:
                    service.updateVehicle();
                    break;
                case 4:
                    service.deleteVehicle();
                    break;
                case 5:
                    subMenu_searchVehicle();
                    break;
                case 6:
                    subMenu_displayVehicleList();
                    break;
                case 7:
                    service.saveAll();
                    break;
                case 8:
                    subMenu_printVehicleList();
            }
        } while (choice != 9);
    }
    
    public static void subMenu_searchVehicle() {
        int choice;
        do {
            System.out.println("---SEARCH VEHICLE---\n"
                    + "1. Search by name\n"
                    + "2. Search by Id\n"
                    + "3. Return main menu");
            choice = service.validator.checkInt("Input the choice:", 1, 3, Status.NORMAL);
            switch (choice) {
                case 1:
                    service.searchVehicleByName();
                    break;
                case 2:
                    service.searchVehicleById();
            }
        } while (choice != 3);
    }
    
    public static void subMenu_displayVehicleList() {
        int choice;
        do {
            System.out.println("---DISPLAY VEHICLE LIST---\n"
                    + "1. Show all\n"
                    + "2. Show by price\n"
                    + "3. Return main menu");
            choice = service.validator.checkInt("Input the choice:", 1, 3, Status.NORMAL);
            switch (choice) {
                case 1:
                    service.showAllVehicles();
                    break;
                case 2:
                    service.showByPriceVehicles();
            }
        } while (choice != 3);
    }
    
    public static void subMenu_printVehicleList() {
        int choice;
        do {
            System.out.println("---PRINT VEHICLE LIST---\n"
                    + "1. Print all\n"
                    + "2. Print by year\n"
                    + "3. Return main menu");
            choice = service.validator.checkInt("Input the choice:", 1, 3, Status.NORMAL);
            switch (choice) {
                case 1:
                    service.showAllVehicles();
                    break;
                case 2:
                    service.showByYearVehicles();
            }
        } while (choice != 3);
    }
}
