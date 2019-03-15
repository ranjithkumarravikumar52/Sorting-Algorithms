package com.sortingalgorithm.controller;

import com.sortingalgorithm.config.AppConfig;
import com.sortingalgorithm.servicelayer.service.Service;
import com.sortingalgorithm.servicelayer.sortalgorithms.SortAlgorithm;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SimulationAppITTest {

	private static final Logger log = LoggerFactory.getLogger(SimulationAppITTest.class);

	@Test
	public void doOneRoundOfSimulationCallingServiceOnlyOnce(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		List<SortAlgorithm> list = new ArrayList<>();
		list.add(context.getBean("bubbleSort", SortAlgorithm.class));
		list.add(context.getBean("insertionSort", SortAlgorithm.class));
		list.add(context.getBean("mergeSort", SortAlgorithm.class));
		list.add(context.getBean("quickSort", SortAlgorithm.class));
		list.add(context.getBean("selectionSort", SortAlgorithm.class));
		list.add(context.getBean("shellSort", SortAlgorithm.class));

		//Create Service layer object
		Service service = context.getBean("serviceImpl", Service.class);
		service.doSimulation(list,1, 5);

	}

}