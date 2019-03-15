package com.sortingalgorithm.daolayer.format;

import com.sortingalgorithm.daolayer.dao.DataAnalysis;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class ExcelFormat implements FormatType {

    private static int i = 1;
    private static FileOutputStream out;
    private static Map<String, Object[]> resultMap = new LinkedHashMap<>();
    private String[] headers;

    public ExcelFormat(String[] headers) {
        this.headers = headers;
        initializeHeaders();
    }

    public static void closeStream() throws IOException {
        out.close();
    }

    private void initializeHeaders() {
        resultMap.put(Integer.toString(i++), this.headers);
    }

    @Override
    public Map<String, Object[]> convert(DataAnalysis dao) {
        return convertDataToExcelFormat(dao);
    }

    @Override
    public boolean save(DataAnalysis dao) {
        convert(dao);
        try {
            //Create a blank sheet from a new workbook, then create a row object
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Sorting Results ");
            XSSFRow row;

            //Iterate over data and write to sheet
            Set<String> keyid = resultMap.keySet();
            int rowId = 0;
            for (String key : keyid) {
                row = spreadsheet.createRow(rowId++);
                Object[] objectArr = resultMap.get(key);
                int cellId = 0;

                for (Object obj : objectArr) {
                    Cell cell = row.createCell(cellId++);
                    cell.setCellValue((String) obj);
                }
            }

            //Write the workbook in file system if successful then return true
            out = new FileOutputStream(
                    new File("src/main/resources/WriteSheet.xlsx"));
            workbook.write(out);
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Map<String, Object[]> convertDataToExcelFormat(DataAnalysis dao) {
        String sortAlgorithmName = dao.getSortAlgorithmName();
        String dataSize = Integer.toString(dao.getDataSize());
        String metricMeasure = dao.getMetricMeasure().toString();

        resultMap.put(Integer.toString(i++), new Object[]{
                sortAlgorithmName,
                dataSize,
                metricMeasure
        });
        return resultMap;
    }

    public static Map<String, Object[]> getResultMap() {
        return resultMap;
    }

    public String[] getHeaders() {
        return headers;
    }
}

