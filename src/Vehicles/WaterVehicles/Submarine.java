package Vehicles.WaterVehicles;

public class Submarine extends WaterVehicle {
    public Submarine(int bibNumber) {
        super();
        super.speed = 5;
        super.bibNumber = bibNumber;
    }

    @Override
    public void Move() {
        if (super.isArrived) {
            return;
        }

        float disadvantageProbability = 0.5f;
        float disadvantageFactor = 0.4f;

        isDisadvantaged = Math.random() < disadvantageProbability;

        super.distanceTravelled += isDisadvantaged ? speed * (1 - disadvantageFactor) : speed;

        super.movesCounter++;
    }

    @Override
    public void Display(int usedCharactersCount, float finishLineDistance) {
        String string = "Submarine #" + super.bibNumber;
        System.out.print(string);

        super.Display(string.length(), finishLineDistance);
    }
}
