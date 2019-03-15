package com.sortingalgorithm.servicelayer.service;

import com.sortingalgorithm.config.AppConfig;
import com.sortingalgorithm.dao.DAO;
import com.sortingalgorithm.model.formattype.ExcelFormatTypeImpl;
import com.sortingalgorithm.model.formattype.FormatType;
import com.sortingalgorithm.model.metric.MetricMeasure;
import com.sortingalgorithm.model.metric.TimeMetricMeasureImpl;
import com.sortingalgorithm.model.pojo.DataAnalysis;
import com.sortingalgorithm.servicelayer.helperutil.generator.IntegerArrayGenerator;
import com.sortingalgorithm.servicelayer.sortalgorithms.SortAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceImpl implements Service {

	private static final Logger log = LoggerFactory.getLogger(ServiceImpl.class);

	@Override
	public boolean doSimulation(List<SortAlgorithm> sortAlgorithmList, int simulationCount, int dataSize) {

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
				// log.info("Sorting...{}", sortAlgorithm.getClass().getSimpleName());
				// log.info("Data size: {}", dataSize);
				sortAlgorithm.sort(copyArrays);
				Long endTime = System.currentTimeMillis();

				//get data analysis object
				DataAnalysis dataAnalysis = getDataAnalysis(sortAlgorithm, copyArrays, startTime, endTime);

				//add it to Data analysis list
				dataAnalysisList.add(dataAnalysis);
			}
		}

		//create DAO object and call save
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		DAO dao = context.getBean("DAOImpl", DAO.class);
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
		// log.info("Time taken: {}", endTime - startTime);
		return new DataAnalysis(sortAlgorithm.getClass().getSimpleName(), copyArrays.length, metricMeasure);
	}
}
