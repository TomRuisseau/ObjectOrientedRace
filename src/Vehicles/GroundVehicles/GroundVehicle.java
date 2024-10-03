package Vehicles.GroundVehicles;
import Vehicles.Vehicle;

abstract class GroundVehicle extends Vehicle {
    public GroundVehicle() {
        super();
    }

    public abstract void Move();
    public void Display(int usedCharactersCount, float finishLineDistance) {
        super.Display(usedCharactersCount, finishLineDistance);
    }
}
