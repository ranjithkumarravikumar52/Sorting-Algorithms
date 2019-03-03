package util.formattype;

import com.sortingalgorithm.util.dao.DataAnalysis;
import com.sortingalgorithm.util.dao.IntegerDataAnalysis;
import com.sortingalgorithm.util.formattype.ExcelFormat;
import com.sortingalgorithm.util.metric.MetricMeasure;
import com.sortingalgorithm.util.metric.TimeMetric;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExcelFormatTest {

    private DataAnalysis<Integer> dao;

    @Before
    public void setup(){
        String sortAlgorithmName = "Dummy sort";
        int dataSize = 3;
        MetricMeasure metricMeasure = new TimeMetric();
        Integer[] inputArray = new Integer[]{3, 2, 1};
        Integer[] outputArray = new Integer[]{1, 2, 3};
        dao = new IntegerDataAnalysis(sortAlgorithmName, dataSize,  metricMeasure);
    }

    @Test
    public void closeStream() {
    }

    @Test
    public void convert_checkExcelHeaders() {
        String[] userInputHeaders = {"sortAlgorithmName", "dataSize", "metricMeasure"};
        ExcelFormat excel = new ExcelFormat(userInputHeaders);
        String actualHeaders = null;
        for(String s: ExcelFormat.getResultMap().keySet()){
            actualHeaders = Arrays.toString(ExcelFormat.getResultMap().get(s));
        }
        assertEquals("headers don't match", Arrays.toString(userInputHeaders), actualHeaders);
    }

    @Test
    public void save_checkExcelSave() {
        String[] userInputHeaders = {"sortAlgorithmName", "dataSize", "metricMeasure"};
        ExcelFormat excel = new ExcelFormat(userInputHeaders);
        assertTrue("Failed to save dao in excel sheet",excel.save(dao));
    }

    @Test
    public void save_checkExcelSaveForMultipleData() {
        String[] userInputHeaders = {"sortAlgorithmName", "dataSize", "metricMeasure"};
        ExcelFormat excel = new ExcelFormat(userInputHeaders);
        assertTrue("Failed to save dao in excel sheet",excel.save(dao));
        assertTrue("Failed to save dao in excel sheet",excel.save(dao));
    }
}