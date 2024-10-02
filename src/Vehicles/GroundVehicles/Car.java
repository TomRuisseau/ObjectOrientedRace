package Vehicles.GroundVehicles;

public class Car extends GroundVehicle {
    public Car() {
        super();
    }


    public void move() {
        super.km += 10;
    }
}
