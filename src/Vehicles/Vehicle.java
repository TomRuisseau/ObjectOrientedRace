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

    public void Arrive(int ranking) {
        this.isArrived = true;
        this.ranking = ranking;
    }

    public int getRanking() {
        return ranking;
    }

    public int getBibNumber() {
        return bibNumber;
    }
}
