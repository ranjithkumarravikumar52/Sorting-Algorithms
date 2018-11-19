package util;

/**
 * <p>Every Sort Algorithm is imagined as a Class. This class has two fields mandatory for any SortAlgorithm.</p>
 * <ul>
 * <li>stepsToSort - steps to sort any given array, the measurement of steps is defined in the sorting algorithm implementation.</li>
 * <li>inputArray - input array to be sorted</li>
 * </ul>
 * <p>The children of this class are: </p>
 * <ul>
 * <li>Random Data Range</li>
 * <li>Fixed Data Range</li>
 * </ul>
 */
abstract public class SortAlgorithm {

    private String sortAlgorithmName;
    private long totalTime;
    private int[] inputArray;
    private int[] outputArray;

    public long getTotalTime() {
        return totalTime;
    }

    protected void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public int[] getInputArray() {
        return inputArray;
    }

    public void setInputArray(int[] inputArray) {
        this.inputArray = inputArray;
    }

    public int[] getOutputArray() {
        return outputArray;
    }

    public void setOutputArray(int[] outputArray) {
        this.outputArray = outputArray;
    }

    public abstract int[] sort(int[] inputArray);

    public String getSortAlgorithmName() {
        return sortAlgorithmName;
    }

    public void setSortAlgorithmName(String sortAlgorithmName) {
        this.sortAlgorithmName = sortAlgorithmName;
    }
}
