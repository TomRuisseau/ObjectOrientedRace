package Vehicles.GroundVehicles;

public class Car extends GroundVehicle {
    public Car(int bibNumber) {
        super();
        super.speed = 6;
        super.bibNumber = bibNumber;
    }

    public void Move() {
        if (super.isArrived) {
            return;
        }

        float disadvantageProbability = 0.75f;
        float disadvantageFactor = 0.45f;

        isDisadvantaged = Math.random() < disadvantageProbability;

        super.distanceTravelled += isDisadvantaged ? speed * (1 - disadvantageFactor) : speed;

        super.movesCounter++;
    }
}
