package com.sortingalgorithm.controller;

import com.sortingalgorithm.config.AppConfig;
import com.sortingalgorithm.dao.DAO;
import com.sortingalgorithm.dao.DAOImpl;
import com.sortingalgorithm.model.formattype.ExcelFormatTypeImpl;
import com.sortingalgorithm.model.formattype.FormatType;
import com.sortingalgorithm.model.metric.MetricMeasure;
import com.sortingalgorithm.model.metric.TimeMetricMeasureImpl;
import com.sortingalgorithm.model.pojo.DataAnalysis;
import com.sortingalgorithm.service.helperutil.generator.IntegerArrayGenerator;
import com.sortingalgorithm.service.sortalgorithms.SortAlgorithm;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class SimulationAppITTest {

	private static final Logger log = LoggerFactory.getLogger(SimulationAppITTest.class);

	@Test
	public void doOneRoundOfSimulation(){
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		SortAlgorithm[] getAllSortClasses = annotationConfigApplicationContext.getBean("getAllSortClasses", SortAlgorithm[].class);

		//basic check
		Integer[] integers = new IntegerArrayGenerator().generateArray(3);
		FormatType formatType = new ExcelFormatTypeImpl(new String[]{"Sort Algorithm", "Data size", "Time Taken"});
		for(SortAlgorithm<Integer> sortAlgorithm: getAllSortClasses){
			System.out.println(sortAlgorithm.getClass().getSimpleName());

			Integer[] copyArrays = new Integer[integers.length];
			System.arraycopy(integers, 0, copyArrays, 0, integers.length);

			System.out.println("Before sort "+Arrays.toString(integers));
			Long startTime = System.currentTimeMillis();
			Integer[] sortedOutput = sortAlgorithm.sort(copyArrays);
			Long endTime = System.currentTimeMillis();

			System.out.println("After sort "+ Arrays.toString(sortedOutput));

			MetricMeasure<Long> metricMeasure = new TimeMetricMeasureImpl<>();
			metricMeasure.setTotalMetric(endTime - startTime);

			DataAnalysis dataAnalysis = new DataAnalysis(sortAlgorithm.getClass().getSimpleName(), copyArrays.length, metricMeasure);
			DAO dao = new DAOImpl(dataAnalysis, formatType);
			dao.saveDataToRepo(dataAnalysis, formatType);

		}
	}

}