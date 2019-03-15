package com.sortingalgorithm.daolayer.dao;

import com.sortingalgorithm.service.metric.MetricMeasure;

public class IntegerDataAnalysis extends DataAnalysis<Integer> {

    public IntegerDataAnalysis(String sortAlgorithmName, int dataSize, MetricMeasure metricMeasure) {
        super(sortAlgorithmName, dataSize, metricMeasure);
    }
}
