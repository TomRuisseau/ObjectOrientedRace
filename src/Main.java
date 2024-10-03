import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numberOfVehiclesTypes = 6;
        int numberOfVehiclesPerType = 2;
        float finishLineDistance = 40;

        RaceTrack track = new RaceTrack(numberOfVehiclesPerType, finishLineDistance, numberOfVehiclesTypes);

        while (!track.IsRaceFinished()) {
            track.NextTurn();
            //track.displayCurrentState();
            //TimeUnit.SECONDS.sleep(1);
        }

        track.displayResults();
    }
}
