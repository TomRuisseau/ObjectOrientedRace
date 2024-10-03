import Vehicles.AirVehicles.Helicopter;
import Vehicles.AirVehicles.Plane;
import Vehicles.GroundVehicles.Bike;
import Vehicles.GroundVehicles.Car;
import Vehicles.Vehicle;
import Vehicles.WaterVehicles.Boat;
import Vehicles.WaterVehicles.Submarine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RaceTrack {
    private int instances;

    private float finishLineDistance; //Km

    private float turnsCounter;

    private List<Vehicle> vehicles;

    private int arrivedVehicles;

    public RaceTrack(int instances, float finishLineDistance, int numberOfVehiclesTypes) {
        this.instances = instances;
        this.finishLineDistance = finishLineDistance;
        this.arrivedVehicles = 0;

        vehicles = new ArrayList<>();

        int bibNumbers = 1;
        for (int i = 0; i < instances; i++) {
            vehicles.add(new Plane(bibNumbers++));
            vehicles.add(new Helicopter(bibNumbers++));
            vehicles.add(new Bike(bibNumbers++));
            vehicles.add(new Car(bibNumbers++));
            vehicles.add(new Boat(bibNumbers++));
            vehicles.add(new Submarine(bibNumbers++));
        }
    }

    public void NextTurn() {
        Collections.shuffle(vehicles); // Make the order of the vehicles random
        for (Vehicle vehicle : vehicles) {
            vehicle.Move();

            if (vehicle.getDistanceTravelled() >= finishLineDistance && !vehicle.IsArrived()) {
                vehicle.Arrive(++arrivedVehicles);
            }
        }
        turnsCounter++;
    }

    public boolean IsRaceFinished() {
        return arrivedVehicles == vehicles.size();
    }

    public void displayResults() {
        displayIndividualRanks();
        System.out.println();
        displayRankingByType();
    }

    private void displayIndividualRanks() {
        // Sort the vehicles by ranking
        vehicles.sort((v1, v2) -> v1.getRanking() - v2.getRanking());

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getClass().getSimpleName() + " arrived in " + vehicle.getMovesCounter() + " moves and is ranked " + vehicle.getRanking());
        }
    }

    private void displayRankingByType(){
        var rankingSumByType = new java.util.HashMap<String, Integer>();

        // Sum the rankings of each type
        for (Vehicle vehicle : vehicles) {
            String vehicleType = vehicle.getClass().getSimpleName();
            int ranking = vehicle.getRanking();
            rankingSumByType.put(vehicleType, rankingSumByType.getOrDefault(vehicleType, 0) + ranking);
        }

        // Sort the types by ranking sum
        var sortedTypes = new ArrayList<>(rankingSumByType.keySet());
        sortedTypes.sort((t1, t2) -> rankingSumByType.get(t1) - rankingSumByType.get(t2));

        // Display the types and their ranking compared to the other types
        for (int i = 0; i < sortedTypes.size(); i++) {
            String type = sortedTypes.get(i);
            System.out.println(type + "s are ranked " + (i + 1) + " as a team with a summed ranking of " + rankingSumByType.get(type));
        }
    }

    public void displayCurrentState() {
        // Clear the console

        // Order vehicles by bib number
        vehicles.sort((v1, v2) -> v1.getBibNumber() - v2.getBibNumber());

        // Display the current state of the vehicles with arrows representing the percentage of the distance travelled

        for (Vehicle vehicle : vehicles) {
            System.out.print(vehicle.getClass().getSimpleName() + " " + vehicle.getBibNumber() + " [");
            float percentage = vehicle.getDistanceTravelled() / finishLineDistance;
            for (int i = 0; i < 10; i++) {
                if (i < percentage * 10) {
                    System.out.print(">");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("]");
        }
    }
}
