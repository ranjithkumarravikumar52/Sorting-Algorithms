package util.dao;

import util.metric.MetricMeasure;

import java.util.Arrays;

public abstract class DataAnalysis<T> {
    private String sortAlgorithmName;
    private int dataSize;
    private MetricMeasure metricMeasure;
    private T[] inputArray;
    private T[] outputArray;

    //TODO builder pattern here
    public DataAnalysis(String sortAlgorithmName, int dataSize, MetricMeasure metricMeasure, T[] inputArray, T[] outputArray) {
        this.sortAlgorithmName = sortAlgorithmName;
        this.dataSize = dataSize;
        this.metricMeasure = metricMeasure;
        this.inputArray = inputArray;
        this.outputArray = outputArray;
    }


    public void setInputArray(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public String getSortAlgorithmName() {
        return sortAlgorithmName;
    }

    public int getDataSize() {
        return dataSize;
    }

    public MetricMeasure getMetricMeasure() {
        return metricMeasure;
    }

    public T[] getInputArray() {
        return inputArray;
    }

    public T[] getOutputArray() {
        return outputArray;
    }

    @Override
    public String toString() {
        return "DataAnalysis{" +
                "sortAlgorithmName='" + sortAlgorithmName + '\'' +
                ", dataSize=" + dataSize +
                ", metricMeasure=" + metricMeasure.getTotalMetric() +
                ", inputArray=" + Arrays.toString(inputArray) +
                ", outputArray=" + Arrays.toString(outputArray) +
                '}';
    }
}
