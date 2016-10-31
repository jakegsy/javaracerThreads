package racer;

import java.util.Random;
public class Main {

    public static void main(String[] args) {
	// write your code here
        RaceOrganizer raceOrganizer = new RaceOrganizer(10.0);
        raceOrganizer.addRunner("Jake");
        raceOrganizer.addRunner("Aaron");
        raceOrganizer.addRunner("Usain");
        raceOrganizer.addRunner("Justin");
        raceOrganizer.addRunner("Cristiano");
        raceOrganizer.startRace();
    }
}
