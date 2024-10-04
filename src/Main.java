import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        int numberOfVehiclesPerType = 2;

        RaceTrack track = new RaceTrack(numberOfVehiclesPerType);

        while (!track.IsRaceFinished()) {
            track.NextTurn();
            track.displayCurrentState();
            TimeUnit.SECONDS.sleep(1);
        }

        track.displayResults();
    }
}
