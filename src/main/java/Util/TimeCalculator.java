package Util;

public class TimeCalculator {

    private long startTime;
    private long endTime;
    private long totalTime;

    public long getTotalTime() {
        this.totalTime = endTime - startTime;
        return this.totalTime;
    }

    public void startTime(){
        this.startTime = System.currentTimeMillis();
    }

    public void endTime(){
        this.endTime = System.currentTimeMillis();
    }

}
