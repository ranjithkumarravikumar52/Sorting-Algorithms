package com.sortingalgorithm.controller;

import com.sortingalgorithm.config.AppConfig;
import com.sortingalgorithm.servicelayer.service.Service;
import com.sortingalgorithm.servicelayer.sortalgorithms.SortAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SimulationApp {

    private static final Logger log = LoggerFactory.getLogger(SimulationApp.class);

    public static void main(String[] args){
        //Get sort algorithm beans from spring container
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        List<SortAlgorithm> list = new ArrayList<>();
        list.add(context.getBean("bubbleSort", SortAlgorithm.class));
        list.add(context.getBean("insertionSort", SortAlgorithm.class));
        list.add(context.getBean("mergeSort", SortAlgorithm.class));
        list.add(context.getBean("quickSort", SortAlgorithm.class));
        list.add(context.getBean("selectionSort", SortAlgorithm.class));
        list.add(context.getBean("shellSort", SortAlgorithm.class));

        //Get Service layer bean
        Service service = context.getBean("serviceImpl", Service.class);
        for(int dataSize = 5; dataSize < 1_000; dataSize = dataSize + 5){
            service.doSimulation(list,2, dataSize);
        }

    }

}
