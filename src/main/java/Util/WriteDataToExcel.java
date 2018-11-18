package Util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class WriteDataToExcel {

    private static int i = 1;
    private static FileOutputStream out;
    private static Map<String, Object[]> sortingResults = new LinkedHashMap<>();

    static {
        sortingResults.put(Integer.toString(i++), new Object[]{
                "Sort Algorithm", "Data Size", "Time taken to sort", "Input Array", "Output Array"});
    }

    public static void writeData(SortAlgorithm[] sortAlgorithm) throws IOException {
        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet("Sorting Results" + System.currentTimeMillis());

        //Create row object
        XSSFRow row;

        //This data needs to be written (Object[])
        for (SortAlgorithm algorithm : sortAlgorithm) {
            sortingResults.put(Integer.toString(i++), new Object[]{
                    algorithm.getSortAlgorithmName(),
                    Integer.toString(ArrayGenerator.SIZE),
                    Long.toString(algorithm.getTotalTime()),
                    Arrays.toString(algorithm.getInputArray()),
                    Arrays.toString(algorithm.getOutputArray())
            });
        }

        //Iterate over data and write to sheet
        Set<String> keyid = sortingResults.keySet();
        int rowId = 0;

        for (String key : keyid) {
            row = spreadsheet.createRow(rowId++);
            Object[] objectArr = sortingResults.get(key);
            int cellId = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellId++);
                cell.setCellValue((String) obj);
            }
        }
        //Write the workbook in file system
        out = new FileOutputStream(
                new File("C:\\Projects\\Sorting-Algorithms\\src\\main\\resources\\WriteSheet.xlsx"));

        workbook.write(out);
    }

    public static void closeStream() throws IOException {
        out.close();
    }
}
