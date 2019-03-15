package com.sortingalgorithm.model.metric;

public interface MetricMeasure<T> {
    T getTotalMetric();
    void setTotalMetric(T metric);
}
