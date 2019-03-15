package com.sortingalgorithm.controller;

import com.sortingalgorithm.config.AppConfig;
import com.sortingalgorithm.servicelayer.helperutil.generator.CharacterArrayGenerator;
import com.sortingalgorithm.servicelayer.sortalgorithms.SortAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class SimulationApp {

    private static final Logger log = LoggerFactory.getLogger(SimulationApp.class);

    public static void main(String[] args){
        //get our beans
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        SortAlgorithm[] getAllSortClasses = annotationConfigApplicationContext.getBean("getAllSortClasses", SortAlgorithm[].class);
        log.info("Beans inside out getAllSortClasses");
        for(SortAlgorithm sortAlgorithm: getAllSortClasses){
            log.info(sortAlgorithm.getClass().getSimpleName());
        }

        //basic check
        for(SortAlgorithm<Character> sortAlgorithm: getAllSortClasses){
            Character[] characters = new CharacterArrayGenerator().generateArray(10);
            Character[] sort = sortAlgorithm.sort(characters);
            log.info(sortAlgorithm.getClass().getSimpleName()+"----->"+Arrays.toString(sort));
        }

        /*
        * Our process flow will look something like this
        * ===== CONTROLLER LAYER ======
        * Controller controller = new Controller();
        * Service servicelayer = new Service(SortAlgorithm sortAlgorithm, MetricMeasure metricMeasure, FormatType formatType);
        * servicelayer.runSimulation(inputArray);
        *
        * ======== SERVICE LAYER ========
        * Long startTime;
        * sortAlgorithm.sort(inputArray)
        * Long endTime;
        * metricMeasure.setTotalTime(endTime - startTime);
        * DataAnalysis dataAnalysis = new DataAnalysis(sortAlgorithm.getClassName(), inputArray.length(), metricMeasure.getTotalTime);
        * DAO model = new DAO(FormatType formatType, DataAnalysis dataAnalysis);
        * model.save(dataAnalysis);
        *
        * ======= DAO Layer ==========
        * FormatType formatType = new ExcelFormatTypeImpl(new String[]{sortAlgorithm.getClassName(), Data Size, Total Time);
        * formatType.save(dataAnalysis);
        *
        * */


    }

}
