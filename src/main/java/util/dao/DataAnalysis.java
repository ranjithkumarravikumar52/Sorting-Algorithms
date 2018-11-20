package util.dao;

import util.metric.MetricMeasure;

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

    public void setSortAlgorithmName(String sortAlgorithmName) {
        this.sortAlgorithmName = sortAlgorithmName;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    public void setMetricMeasure(MetricMeasure metricMeasure) {
        this.metricMeasure = metricMeasure;
    }

    public void setInputArray(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public void setOutputArray(T[] outputArray) {
        this.outputArray = outputArray;
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
}
