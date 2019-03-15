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
import java.util.List;

public class ServiceImpl implements Service {
	@Override
	public boolean doSimulation(List<SortAlgorithm>  sortAlgorithmList, int simulationCount, int dataSize) {

		FormatType formatType = new ExcelFormatTypeImpl(new String[]{"Sort Algorithm", "Data size", "Time Taken"});
		List<DataAnalysis> dataAnalysisList = new ArrayList<>();

		while (simulationCount-- > 0) {
			//generate array
			Integer[] integers = new IntegerArrayGenerator().generateArray(dataSize);

			//one round of simulation for all the sort-algorithm types
			for (SortAlgorithm<Integer> sortAlgorithm : sortAlgorithmList) {
				//get a copy of array
				Integer[] copyArrays = getIntegersCopy(integers);

				//perform sort
				Long startTime = System.currentTimeMillis();
				sortAlgorithm.sort(copyArrays);
				Long endTime = System.currentTimeMillis();

				//get data analysis object
				DataAnalysis dataAnalysis = getDataAnalysis(sortAlgorithm, copyArrays, startTime, endTime);

				//add it to Data analysis list
				dataAnalysisList.add(dataAnalysis);
			}
		}

		//create DAO object and call save
		DAO dao = new DAOImpl();
		return dao.saveDataToRepo(dataAnalysisList, formatType);
	}

	/**
	 * Copy arrays to a buffer array
	 */
	private Integer[] getIntegersCopy(Integer[] integers) {
		Integer[] copyArrays = new Integer[integers.length];
		System.arraycopy(integers, 0, copyArrays, 0, integers.length);
		return copyArrays;
	}

	/**
	 * set metric and form a POJO object
	 */
	private DataAnalysis getDataAnalysis(SortAlgorithm<Integer> sortAlgorithm, Integer[] copyArrays, Long startTime, Long endTime) {
		MetricMeasure<Long> metricMeasure = new TimeMetricMeasureImpl<>();
		metricMeasure.setTotalMetric(endTime - startTime);
		return new DataAnalysis(sortAlgorithm.getClass().getSimpleName(), copyArrays.length, metricMeasure);
	}
}
