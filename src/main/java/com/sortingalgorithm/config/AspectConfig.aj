package com.sortingalgorithm.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {
    /**application logger**/
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(AspectConfig.class);

    //point cut declaration for sortalgorithms package
    @Pointcut("execution(public Integer[] sort(..))")
    private void forSortAlgorithmPackage(){}

    //point cut declaration for util package
    @Pointcut("execution(* com.sortingalgorithm.util.*.*(..))")
    private void forUtilPackage(){}

    //add @Before
    @Before("forSortAlgorithmPackage() || forUtilPackage()")
    public void before(JoinPoint joinPoint){
        //display method we are calling
        String methodSignature = joinPoint.getSignature().toShortString();
        LOG.info("===> in @Before: calling method : "+methodSignature);

        //display the arguments to the method
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            LOG.info("====> arguments: " + arg.toString());
        }
    }

    //add @AfterReturning
    @AfterReturning(pointcut = "forSortAlgorithmPackage() || forUtilPackage()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        //display method we are returning from
        String methodSignature = joinPoint.getSignature().toShortString();
        LOG.info("====> in @AfterReturning: from method: " + methodSignature);

        //display data we are returning
        LOG.info( "=====> result: " + result);
    }

}
