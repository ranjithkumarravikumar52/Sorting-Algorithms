package com.sortingalgorithm.servicelayer.service;

import com.sortingalgorithm.dao.DAO;
import com.sortingalgorithm.dao.DAOImpl;
import com.sortingalgorithm.model.formattype.ExcelFormatTypeImpl;
import com.sortingalgorithm.model.formattype.FormatType;
import com.sortingalgorithm.model.metric.MetricMeasure;
import com.sortingalgorithm.model.metric.TimeMetricMeasureImpl;
import com.sortingalgorithm.model.pojo.DataAnalysis;
import com.sortingalgorithm.servicelayer.helperutil.generator.IntegerArrayGenerator;
import com.sortingalgorithm.servicelayer.sortalgorithms.SortAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceImpl implements Service {
	@Override
	public boolean doSimulation(List<SortAlgorithm>  sortAlgorithmList, int simulationCount, int dataSize) {

		FormatType formatType = new ExcelFormatTypeImpl(new String[]{"Sort Algorithm", "Data size", "Time Taken"});
		List<DataAnalysis> dataAnalysisList = new ArrayList<>();

		while (simulationCount-- > 0) {
			//generate array
			Integer[] integers = new IntegerArrayGenerator().generateArray(dataSize);

			//one round of simulation for all the sortalgorithm types
			for (SortAlgorithm<Integer> sortAlgorithm : sortAlgorithmList) {
				System.out.println(sortAlgorithm.getClass().getSimpleName());

				Integer[] copyArrays = new Integer[integers.length];
				System.arraycopy(integers, 0, copyArrays, 0, integers.length);


				System.out.println("Before sort " + Arrays.toString(integers));
				Long startTime = System.currentTimeMillis();
				Integer[] sortedOutput = sortAlgorithm.sort(copyArrays);
				Long endTime = System.currentTimeMillis();
				System.out.println("After sort " + Arrays.toString(sortedOutput));


				MetricMeasure<Long> metricMeasure = new TimeMetricMeasureImpl<>();
				metricMeasure.setTotalMetric(endTime - startTime);
				DataAnalysis dataAnalysis = new DataAnalysis(sortAlgorithm.getClass().getSimpleName(), copyArrays.length, metricMeasure);
				dataAnalysisList.add(dataAnalysis);
			}
		}

		DAO dao = new DAOImpl();
		return dao.saveDataToRepo(dataAnalysisList, formatType);
	}
}
