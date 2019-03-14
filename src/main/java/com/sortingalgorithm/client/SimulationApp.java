package com.sortingalgorithm.client;

import com.sortingalgorithm.config.AppConfig;
import com.sortingalgorithm.sortalgorithms.SortAlgorithm;
import com.sortingalgorithm.util.generator.CharacterArrayGenerator;
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

    }

}
