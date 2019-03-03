package util.datapersistence;

import com.sortingalgorithm.util.dao.DataAnalysis;
import com.sortingalgorithm.util.dao.IntegerDataAnalysis;
import com.sortingalgorithm.util.datapersistence.DataPersistence;
import com.sortingalgorithm.util.formattype.ExcelFormat;
import com.sortingalgorithm.util.formattype.FormatType;
import com.sortingalgorithm.util.metric.MetricMeasure;
import com.sortingalgorithm.util.metric.TimeMetric;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

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