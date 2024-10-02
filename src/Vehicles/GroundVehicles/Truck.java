package Vehicles.GroundVehicles;

public class Truck extends GroundVehicle {
    public Truck() {
        super();
    }

    public void move() {
        super.km += 8;
    }
}
