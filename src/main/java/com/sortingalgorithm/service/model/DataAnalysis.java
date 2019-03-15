package com.sortingalgorithm.service.model;

import com.sortingalgorithm.service.metric.MetricMeasure;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DataAnalysis {
    private String sortAlgorithmName;
    private int dataSize;
    private MetricMeasure metricMeasure;

    public DataAnalysis(String sortAlgorithmName, int dataSize, MetricMeasure metricMeasure) {
        this.sortAlgorithmName = sortAlgorithmName;
        this.dataSize = dataSize;
        this.metricMeasure = metricMeasure;
    }

}
