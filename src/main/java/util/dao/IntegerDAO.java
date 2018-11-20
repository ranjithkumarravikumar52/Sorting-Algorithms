package util.dao;

import util.metric.MetricMeasure;

public class IntegerDAO extends DataAnalysis<Integer> {

    public IntegerDAO(String sortAlgorithmName, int dataSize, MetricMeasure metricMeasure, Integer[] inputArray, Integer[] outputArray) {
        super(sortAlgorithmName, dataSize, metricMeasure, inputArray, outputArray);
    }
}
