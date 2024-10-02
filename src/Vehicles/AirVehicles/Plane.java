package Vehicles.AirVehicles;

public class Plane extends AirVehicle {
    public Plane() {
        super();
    }

    public void move() {
        super.km += 50;
    }
}
