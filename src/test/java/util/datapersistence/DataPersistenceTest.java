package util.datapersistence;

import org.junit.Before;
import org.junit.Test;
import util.dao.DataAnalysis;
import util.dao.IntegerDataAnalysis;
import util.formattype.ExcelFormat;
import util.formattype.FormatType;
import util.metric.MetricMeasure;
import util.metric.TimeMetric;

import static org.junit.Assert.*;

public class DataPersistenceTest {

    private DataAnalysis<Integer> dao;

    @Before
    public void setup(){
        String sortAlgorithmName = "Dummy sort1";
        int dataSize = 3;
        MetricMeasure metricMeasure = new TimeMetric();
        Integer[] inputArray = new Integer[]{3, 2, 1};
        Integer[] outputArray = new Integer[]{1, 2, 3};
        dao = new IntegerDataAnalysis(sortAlgorithmName, dataSize,  metricMeasure);
    }


    @Test
    public void saveData() {
        String[] userInputHeaders = {"sortAlgorithmName", "dataSize", "metricMeasure"};
        FormatType excel = new ExcelFormat(userInputHeaders);
        DataPersistence dataPersistence = new DataPersistence(dao, excel);
        assertTrue("Failed to save data", dataPersistence.saveData());
    }
}