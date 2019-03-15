package com.sortingalgorithm.controller;

import com.sortingalgorithm.config.AppConfig;
import com.sortingalgorithm.servicelayer.service.Service;
import com.sortingalgorithm.servicelayer.service.ServiceImpl;
import com.sortingalgorithm.servicelayer.sortalgorithms.SortAlgorithm;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class SimulationAppITTest {

	private static final Logger log = LoggerFactory.getLogger(SimulationAppITTest.class);

	@Test
	public void doOneRoundOfSimulationCallingServiceOnlyOnce(){
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		SortAlgorithm[] getAllSortClasses = annotationConfigApplicationContext.getBean("getAllSortClasses", SortAlgorithm[].class);
		List<SortAlgorithm> sortAlgorithmsList = Arrays.asList(getAllSortClasses);


		//Create Service layer object
		Service service = new ServiceImpl();
		service.doSimulation(sortAlgorithmsList,1, 5);

	}

}