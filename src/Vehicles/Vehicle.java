package Vehicles;

public abstract class Vehicle {

    public abstract void Move();

    protected float distanceTravelled; //Km
    protected int movesCounter;

    protected float speed; //Km per turn

    protected boolean isDisadvantaged;

    protected boolean isArrived;
    private int ranking;

    protected int bibNumber;

    public void Display(int usedCharactersCount, float finishLineDistance) {
        // Display spaces to align the beginning of the line
        for (int i = 0; i < 20 - usedCharactersCount; i++) {
            System.out.print(" ");
        }

        int lineCount = 0;
        // Draw a line representing the distance travelled by the vehicle
        for (int i = 0; i < Math.ceil(distanceTravelled / finishLineDistance * 20); i++) {
            System.out.print("-");
            lineCount++;
        }

        System.out.print(isArrived ? "-" : ">");


        // Draw the finish line
        for (int i = 0; i < 20 - lineCount; i++) {
            System.out.print(" ");
        }
        System.out.print("|  ");

        // Display the distance travelled by the vehicle, formatted to 2 decimal places
        System.out.printf("%.2f", distanceTravelled);
        System.out.print(" Km         ");
        System.out.println(isArrived ? this.ranking : "");
    }

    public Vehicle() {
        this.distanceTravelled = 0;
        this.movesCounter = 0;
    }

    public float getDistanceTravelled() {
        return distanceTravelled;
    }

    public int getMovesCounter() {
        return movesCounter;
    }

    public boolean IsArrived() {
        return isArrived;
    }

    public void Arrive(int ranking, float finishLineDistance) {
        this.isArrived = true;
        this.ranking = ranking;
        distanceTravelled = finishLineDistance;
    }

    public int getRanking() {
        return ranking;
    }

    public int getBibNumber() {
        return bibNumber;
    }
}
