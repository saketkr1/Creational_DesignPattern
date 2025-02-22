
/*
    * Prototype pattern is used when the Object creation is a costly affair and requires a lot of time and resources and you have a similar object already existing.
*/

/*
Structure of Prototype Pattern:
1. Prototype: An interface with a self-cloning method declared.
2. Concrete Prototype: An object that implements the Prototype interface and returns a duplicate of itself is referred to as a concrete prototype.
3. Client: an entity that requests a new object be created by duplicating the prototype.
*/

import java.util.HashMap;
import java.util.Map;

interface Prototype {
    Vehicle clone();
}

class Vehicle implements Prototype {
    private String model;
    private String color;
    private int year;
    public Vehicle() {
    }

    public Vehicle(String model, String color, int year) {
        this.model = model;
        this.color = color;
        this.year = year;
    }
    public Vehicle(Vehicle vehicle) {
        this.model = vehicle.model;
        this.color = vehicle.color;
        this.year = vehicle.year;
    }

    @Override
    public Vehicle clone() {
        return new Vehicle(this);
    }

    public void showDetails() {
        System.out.println("Model: " + model + ", Color: " + color + ", Year: " + year);
    }

}

public class PrototypeDemo {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("SUV", "Black", 2021);
        // Vehicle vehicle2 = vehicle1.clone();
        Map<String, Vehicle> vehicleMap = new HashMap<>();
        vehicleMap.put("SUV", vehicle1);

        vehicle1.showDetails();
       // vehicle2.showDetails();
    }
    public static Vehicle getVehicle(String model, Map<String, Vehicle> vehicleMap) {
        return vehicleMap.get(model).clone();
    }
}
