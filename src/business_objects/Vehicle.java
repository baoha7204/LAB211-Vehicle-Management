
package business_objects;

import java.io.Serializable;
import java.util.Comparator;

public class Vehicle implements Serializable{
    public static final String regex =  "V\\d{4}";
    private String ID_Vehicle;
    private String Name_Vehicle;
    private String color_Vehicle;
    private double price;
    private String brand_Vehicle;
    private VehicleType type;
    private int productYear;

    public Vehicle() {
    }

    public Vehicle(String ID_Vehicle, String Name_Vehicle, String color_Vehicle, double price, String brand_Vehicle, VehicleType type, int productYear) {
        this.ID_Vehicle = ID_Vehicle;
        this.Name_Vehicle = Name_Vehicle;
        this.color_Vehicle = color_Vehicle;
        this.price = price;
        this.brand_Vehicle = brand_Vehicle;
        this.type = type;
        this.productYear = productYear;
    }

    public String getID_Vehicle() {
        return ID_Vehicle;
    }

    public void setID_Vehicle(String ID_Vehicle) {
        this.ID_Vehicle = ID_Vehicle;
    }

    public String getName_Vehicle() {
        return Name_Vehicle;
    }

    public boolean setName_Vehicle(String Name_Vehicle) {
        if(Name_Vehicle.isEmpty()){
            return false;
        }
        this.Name_Vehicle = Name_Vehicle;
        return true;
    }

    public String getColor_Vehicle() {
        return color_Vehicle;
    }

    public boolean setColor_Vehicle(String color_Vehicle) {
        if(color_Vehicle.isEmpty()){
            return false;
        }
        this.color_Vehicle = color_Vehicle;
        return true;
    }

    public double getPrice() {
        return price;
    }

    public boolean setPrice(double price) {
        if(price < 0){
            return false;
        }
        this.price = price;
        return true;
    }

    public String getBrand_Vehicle() {
        return brand_Vehicle;
    }

    public boolean setBrand_Vehicle(String brand_Vehicle) {
        if(brand_Vehicle.isEmpty()){
            return false;
        }
        this.brand_Vehicle = brand_Vehicle;
        return true;
    }

    public VehicleType getType() {
        return type;
    }

    public boolean setType(VehicleType type) {
        if(type == null){
            return false;
        }
        this.type = type;
        return true;
    }

    public int getProductYear() {
        return productYear;
    }

    public boolean setProductYear(int productYear) {
        if(productYear < 0){
            return false;
        }
        this.productYear = productYear;
        return true;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "ID=" + ID_Vehicle + ", Name=" + Name_Vehicle + ", Color=" + color_Vehicle + ", Price=" + price + ", Brand=" + brand_Vehicle + ", Type=" + type + ", Year=" + productYear + '}';
    }
    
    public static Comparator compareNameDesc = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Vehicle v1 = (Vehicle) o1;
            Vehicle v2 = (Vehicle) o2;
            return v2.getName_Vehicle().compareToIgnoreCase(v1.getName_Vehicle());
        }
    };
    
    public static Comparator comparePriceDesc = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Vehicle v1 = (Vehicle) o1;
            Vehicle v2 = (Vehicle) o2;
            return (int) (v2.getPrice() - v1.getPrice());
        }
    };
    
    public static Comparator compareYearDesc = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Vehicle v1 = (Vehicle) o1;
            Vehicle v2 = (Vehicle) o2;
            return v2.getProductYear()- v1.getProductYear();
        }
    };
}
