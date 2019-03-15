package com.sortingalgorithm.model.metric;

public class TimeMetricMeasureImpl<T extends Long> implements MetricMeasure<Long>{

    private Long startTime;
    private Long endTime;
    private Long totalTime;

    @Override
    public Long getTotalMetric() {
        totalTime =  endTime - startTime;
        return totalTime;
    }

    public void startTime(){
        this.startTime = System.currentTimeMillis();
    }

    public void endTime(){
        this.endTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return Long.toString(totalTime);
    }
}
