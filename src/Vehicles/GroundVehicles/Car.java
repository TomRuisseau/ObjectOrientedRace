package Vehicles.GroundVehicles;

public class Car extends GroundVehicle {
    public Car(int bibNumber) {
        super();
        super.speed = 6;
        super.bibNumber = bibNumber;
    }

    @Override
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

    @Override
    public void Display(int usedCharactersCount, float finishLineDistance) {
        String string = "Bike #" + super.bibNumber;
        System.out.print(string);

        super.Display(string.length(), finishLineDistance);
    }
}
