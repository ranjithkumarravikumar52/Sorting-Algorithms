package com.sortingalgorithm.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class AspectConfig {
    //setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    //point cut declaration for sortalgorithms package
    @Pointcut("execution(public Integer[] sort(..))")
    private void forSortAlgorithmPackage(){}

    //point cut declaration for util package
    @Pointcut("execution(* wholepackage.util.*.*(..))")
    private void forUtilPackage(){}

    //add @Before
    @Before("forSortAlgorithmPackage() || forUtilPackage()")
    public void before(JoinPoint joinPoint){
        //display method we are calling
        String methodSignature = joinPoint.getSignature().toShortString();
        logger.info("===> in @Before: calling method : "+methodSignature);

        //display the arguments to the method
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logger.info("====> arguments: " + arg.toString());
        }
    }

    //add @AfterReturning
    @AfterReturning(pointcut = "forSortAlgorithmPackage() || forUtilPackage()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        //display method we are returning from
        String methodSignature = joinPoint.getSignature().toShortString();
        logger.info("====> in @AfterReturning: from method: " + methodSignature);

        //display data we are returning
        logger.info( "=====> result: " + result);
    }

}
