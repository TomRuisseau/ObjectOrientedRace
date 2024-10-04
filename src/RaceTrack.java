import Vehicles.AirVehicles.Helicopter;
import Vehicles.AirVehicles.Plane;
import Vehicles.GroundVehicles.Bike;
import Vehicles.GroundVehicles.Car;
import Vehicles.Vehicle;
import Vehicles.WaterVehicles.Boat;
import Vehicles.WaterVehicles.Submarine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceTrack {
    private final float finishLineDistance; //Km
    private final int instances;  // Number of vehicles per type

    private final List<Vehicle> vehicles;

    private int arrivedVehicles;

    public RaceTrack(int instances) {
        this.instances = instances;

        // Randomize the finish line distance between 30 and 60 Km
        this.finishLineDistance = (float) (Math.random() * 30 + 30);
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

    // Move each vehicle and check if it has arrived
    public void NextTurn() {
        Collections.shuffle(vehicles); // Make the order of the vehicles random for fairness
        for (Vehicle vehicle : vehicles) {
            vehicle.Move();

            // If the vehicle has arrived, warn it and give it its ranking
            if (vehicle.getDistanceTravelled() >= finishLineDistance && !vehicle.IsArrived()) {
                vehicle.Arrive(++arrivedVehicles, finishLineDistance);
            }
        }
    }

    public boolean IsRaceFinished() {
        return arrivedVehicles == vehicles.size();
    }

    // Show individual rankings and rankings by type, one at a time
    public void displayResults() {
        ClearConsole();
        displayIndividualRanks();
        System.out.println();
        System.out.println("Press enter to display the ranking by type");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ClearConsole();
        displayRankingByType();
    }

    // Display the ranks of each vehicle, differentiated by bib number
    private void displayIndividualRanks() {
        // Sort the vehicles by ranking
        vehicles.sort((v1, v2) -> v1.getRanking() - v2.getRanking());

        // Print the header row
        System.out.printf("%-15s %-15s %-15s%n", "Vehicle Type", "Moves", "Ranking");
        System.out.println("-----------------------------------------------------");

        // Print the rows for each vehicle
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%-15s %-15d %-15d%n", vehicle.getClass().getSimpleName(), vehicle.getMovesCounter(), vehicle.getRanking());
        }
    }


    private void displayRankingByType() {
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

        // Print the header row
        System.out.printf("%-15s %-15s %-15s%n", "Vehicle Type", "Team Rank", "Average Ranking");
        System.out.println("-----------------------------------------------------");

        // Display the types and their ranking compared to the other types
        for (int i = 0; i < sortedTypes.size(); i++) {
            String type = sortedTypes.get(i);
            int summedRanking = rankingSumByType.get(type);
            System.out.printf("%-15s %-15d %-15.1f%n", type + "s", (i + 1), (float)summedRanking / instances);
        }
    }

    public void displayCurrentState() {
        ClearConsole();

        System.out.println("Finish line distance: " + finishLineDistance + " Km");

        // Order vehicles by bib number
        vehicles.sort((v1, v2) -> v1.getBibNumber() - v2.getBibNumber());

        // Display the current state of the vehicles with arrows representing the percentage of the distance travelled
        for (Vehicle vehicle : vehicles) {
            vehicle.Display(0, finishLineDistance);
        }
    }

    private void ClearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
