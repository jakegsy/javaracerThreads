package racer;

import java.util.Random;

public class Runner extends Thread {

    private static int runnerNo = 0;

    private double lengthOfRace;
    private Random rand = new Random();
    private double distCovered;
    private int id;
    private String name;
    private RaceOrganizer raceOrganizer;

    public Runner(double lengthOfRace, String name, RaceOrganizer raceOrganizer){
        this.lengthOfRace = lengthOfRace;
        this.distCovered = 0.0;
        this.name = name;
        this.id = ++runnerNo;
        this.raceOrganizer = raceOrganizer;

    }
    @Override
    public void run() {
        System.out.println(this.name + " is running.");
        long startTime = System.nanoTime();
        while(isRaceGoing()){
            try{
                double wait = rand.nextDouble()*1000;
                Thread.sleep((long) wait);
            } catch(InterruptedException e){
                e.printStackTrace();
            } finally{
                increaseDistCovered();
            }
        }
        long raceTime = System.nanoTime() - startTime;
        this.raceOrganizer.finishRace(this.toString() + raceTime + " nanoseconds.");
    }

    private boolean isRaceGoing(){
        return this.distCovered < this.lengthOfRace;
    }

    private void increaseDistCovered(){
        this.distCovered += rand.nextDouble();
    }

    @Override
    public String toString(){
        return "Runner " + this.name + " of id " + this.id + " who finished in ";
    }
}
