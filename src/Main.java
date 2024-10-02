import Vehicles.*;
import Vehicles.GroundVehicles.*;
import Vehicles.AirVehicles.*;
import Vehicles.WaterVehicles.*;

public class Main {
    public static void main(String[] args) {
        // Create a list of vehicles
        Vehicle[] vehicles = new Vehicle[9];

        //Fill the list with one of each type of vehicle
        vehicles[0] = new Bike();
        vehicles[1] = new MotorCycle();
        vehicles[2] = new Car();
        vehicles[3] = new Truck();
        vehicles[4] = new Bus();
        vehicles[5] = new Helicopter();
        vehicles[6] = new Plane();
        vehicles[7] = new Boat();
        vehicles[8] = new Submarine();

        // Race all vehicles 10 times
        for (int i = 0; i < 10; i++) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();
            }
        }

        // Print the distance traveled by each vehicle
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getClass().getSimpleName() + " has traveled " + vehicle.getKm() + " km.");
        }
    }
}