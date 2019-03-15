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
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AspectConfig.class);

    //point cut declaration for sortalgorithms package
    @Pointcut("execution(public * sort(..))")
    private void forSortAlgorithmPackage(){}

    //add @Before
    @Before("forSortAlgorithmPackage()")
    public void before(JoinPoint joinPoint){
        //display method we are calling
        String methodSignature = joinPoint.getSignature().toShortString();
        log.info("===> in @Before: calling method : "+methodSignature);

        //display the arguments to the method
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.info("====> arguments: " + arg.toString());
        }
    }

    //add @AfterReturning
    @AfterReturning(pointcut = "forSortAlgorithmPackage()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        //display method we are returning from
        String methodSignature = joinPoint.getSignature().toShortString();
        log.info("====> in @AfterReturning: from method: " + methodSignature);

        //display data we are returning
        log.info( "=====> result: " + result);
    }

}
