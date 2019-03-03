package com.sortingalgorithm.client;

import com.sortingalgorithm.config.AppConfig;
import com.sortingalgorithm.sortalgorithms.SortAlgorithm;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class SimulationApp {

    public static void main(String[] args){
        //get our beans
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        SortAlgorithm[] getAllSortClasses = annotationConfigApplicationContext.getBean("getAllSortClasses", SortAlgorithm[].class);
        System.out.println(Arrays.toString(getAllSortClasses));
    }


}
