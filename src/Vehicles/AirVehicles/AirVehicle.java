package Vehicles.AirVehicles;

import Vehicles.Vehicle;

abstract class AirVehicle extends Vehicle {
    public AirVehicle() {
        super();
    }

    public abstract void Move();

    public void Display(int usedCharactersCount, float finishLineDistance) {
        super.Display(usedCharactersCount, finishLineDistance);
    }
}
