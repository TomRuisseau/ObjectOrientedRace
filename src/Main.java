import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        int numberOfVehiclesPerType = 2;

        RaceTrack track = new RaceTrack(numberOfVehiclesPerType);

        // The race takes place until all vehicles arrive
        while (!track.IsRaceFinished()) {
            track.NextTurn();
            track.displayCurrentState();
            // Wait to let the user see the progress
            TimeUnit.SECONDS.sleep(1);
        }

        track.displayResults();
    }
}
