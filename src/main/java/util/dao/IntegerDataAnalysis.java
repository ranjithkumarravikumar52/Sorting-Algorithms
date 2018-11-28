package util.dao;

import util.metric.MetricMeasure;

public class IntegerDataAnalysis extends DataAnalysis<Integer> {

    public IntegerDataAnalysis(String sortAlgorithmName, int dataSize, MetricMeasure metricMeasure) {
        super(sortAlgorithmName, dataSize, metricMeasure);
    }
}
