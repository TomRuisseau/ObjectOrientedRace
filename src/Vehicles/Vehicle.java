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
        // Calculate the distance progress
        int progressMarks = (int) Math.ceil(distanceTravelled / finishLineDistance * 20);

        // Print spaces to align the beginning of the line
        System.out.printf("%-" + (15 - usedCharactersCount) + "s", "");

        // Draw the line representing the distance travelled
        for (int i = 0; i < progressMarks; i++) {
            System.out.print("-");
        }

        System.out.print(isArrived ? "-" : ">");

        // Draw spaces after the progress line to the finish
        for (int i = 0; i < 20 - progressMarks; i++) {
            System.out.print(" ");
        }

        // Print the finish line, distance, and ranking if arrived
        System.out.printf("|  %.2f Km    %s%n", distanceTravelled, isArrived ? this.ranking : "");
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

        // Forcing vehicle to stop on the finish line
        distanceTravelled = finishLineDistance;
    }

    public int getRanking() {
        return ranking;
    }

    public int getBibNumber() {
        return bibNumber;
    }
}
