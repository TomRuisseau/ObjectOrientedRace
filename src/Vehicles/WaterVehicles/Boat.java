package Vehicles.WaterVehicles;

public class Boat extends WaterVehicle {
    public Boat(int bibNumber) {
        super();
        super.speed = 5.5f;
        super.bibNumber = bibNumber;
    }

    public void Move() {
        if (super.isArrived) {
            return;
        }

        float disadvantageProbability = 0.4f;
        float disadvantageFactor = 0.65f;

        isDisadvantaged = Math.random() < disadvantageProbability;

        super.distanceTravelled += isDisadvantaged ? speed * (1 - disadvantageFactor) : speed;

        super.movesCounter++;
    }
}
