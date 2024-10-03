package Vehicles.WaterVehicles;
import Vehicles.Vehicle;

public abstract class WaterVehicle extends Vehicle {
    public WaterVehicle() {
        super();
    }

    public abstract void Move();
    public void Display(int usedCharactersCount, float finishLineDistance) {
        super.Display(usedCharactersCount, finishLineDistance);
    }
}
