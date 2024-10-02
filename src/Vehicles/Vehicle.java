package Vehicles;

public abstract class Vehicle {

    public Vehicle() {
        km = 0;
    }

    public abstract void move();

    public int getKm(){
        return km;
    }

    protected int km;


}
