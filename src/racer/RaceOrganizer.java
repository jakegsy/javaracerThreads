package racer;
import java.util.ArrayList;

public class RaceOrganizer {

    private double lengthOfRace;
    private int raceRank;
    private ArrayList<Runner> runners;
    private int runnersStillRunning;

    public RaceOrganizer(double lengthOfRace){
        this.lengthOfRace = lengthOfRace;
        this.raceRank = 0;
        this.runners = new ArrayList<Runner>();
    }

    public synchronized void finishRace(String printMe){
        System.out.println("Coming in at #" +
                ++this.raceRank
                + " " + printMe);
        if(this.runnersStillRunning == 0){
            System.out.println("The race is over.");
        }
    }

    public void addRunner(String name){
        this.runners.add(new Runner(this.lengthOfRace,name,this));
    }

    public void startRace(){
        this.runnersStillRunning = this.runners.size();
        for(Runner runner:this.runners){
            runner.start();
        }
    }
}
