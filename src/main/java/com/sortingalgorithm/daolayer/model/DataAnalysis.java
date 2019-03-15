package com.sortingalgorithm.daolayer.model;

import com.sortingalgorithm.service.metric.MetricMeasure;


public class DataAnalysis {
    private String sortAlgorithmName;
    private int dataSize;
    private MetricMeasure metricMeasure;

    public DataAnalysis(String sortAlgorithmName, int dataSize, MetricMeasure metricMeasure) {
        this.sortAlgorithmName = sortAlgorithmName;
        this.dataSize = dataSize;
        this.metricMeasure = metricMeasure;
    }


    /*public String getSortAlgorithmName() {
        return sortAlgorithmName;
    }

    public int getDataSize() {
        return dataSize;
    }

    public MetricMeasure getMetricMeasure() {
        return metricMeasure;
    }*/

    @Override
    public String toString() {
        return "DataAnalysis{" +
                "sortAlgorithmName='" + sortAlgorithmName + '\'' +
                ", dataSize=" + dataSize +
                ", metricMeasure=" + metricMeasure.getTotalMetric() +
                '}';
    }
}
