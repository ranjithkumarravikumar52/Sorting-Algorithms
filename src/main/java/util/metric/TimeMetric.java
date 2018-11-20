package util.metric;

public class TimeMetric implements MetricMeasure<Long>{

    private long startTime;
    private long endTime;

    @Override
    public Long getTotalMetric() {
        return endTime - startTime;
    }

    public void startTime(){
        this.startTime = System.currentTimeMillis();
    }

    public void endTime(){
        this.endTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return Long.toString(getTotalMetric());
    }
}
