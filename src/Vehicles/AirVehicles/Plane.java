package Vehicles.AirVehicles;

public class Plane extends AirVehicle {
    public Plane(int bibNumber) {
        super();
        super.speed = 8;
        super.bibNumber = bibNumber;
    }

    public void Move() {
        if (super.isArrived) {
            return;
        }

        float disadvantageProbability = 0.7f;
        float disadvantageFactor = 0.7f;

        isDisadvantaged = Math.random() < disadvantageProbability;

        super.distanceTravelled += isDisadvantaged ? speed * (1 - disadvantageFactor) : speed;

        super.movesCounter++;
    }

    @Override
    public void Display(int usedCharactersCount, float finishLineDistance) {
        String string = "Plane #" + super.bibNumber;
        System.out.print(string);

        super.Display(string.length(), finishLineDistance);
    }
}
