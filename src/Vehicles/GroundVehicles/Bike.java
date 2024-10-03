package Vehicles.GroundVehicles;

public class Bike extends GroundVehicle {
    public Bike(int bibNumber) {
        super();
        super.speed = 4;
        super.bibNumber = bibNumber;
    }

    public void Move() {
        if (super.isArrived) {
            return;
        }

        float disadvantageProbability = 0.02f;
        float disadvantageFactor = 0.05f;

        isDisadvantaged = Math.random() < disadvantageProbability;

        super.distanceTravelled += isDisadvantaged ? speed * (1 - disadvantageFactor) : speed;

        super.movesCounter++;
    }
}
