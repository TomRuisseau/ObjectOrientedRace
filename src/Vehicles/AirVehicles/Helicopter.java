package Vehicles.AirVehicles;

public class Helicopter extends AirVehicle {
    public Helicopter(int bibNumber) {
        super();
        super.speed = 7;
        super.bibNumber = bibNumber;
    }

    @Override
    public void Move() {
        if (super.isArrived) {
            return;
        }

        float disadvantageProbability = 0.42f;
        float disadvantageFactor = 1;

        isDisadvantaged = Math.random() < disadvantageProbability;

        super.distanceTravelled += isDisadvantaged ? speed * (1 - disadvantageFactor) : speed;

        super.movesCounter++;
    }


    public void Display(int usedCharactersCount, float finishLineDistance) {
        String string = "Helicopter #" + super.bibNumber;
        System.out.print(string);

        super.Display(string.length(), finishLineDistance);
    }
}
