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
	@Pointcut("execution(public * *.sort(..))")
	private void forSortAlgorithmPackage(){}

	// point cut declaration for service layer
	@Pointcut("execution(public * doSimulation(..))")
	private void forServiceLayer(){}

	//point cut declaration for dao layer
	@Pointcut("execution(public * saveDataToRepo(..))")
	private void forDAOLayer(){}


	//add @Before
	@Before("forSortAlgorithmPackage() || forServiceLayer() || forDAOLayer()")
	public void before(JoinPoint joinPoint){
		//display method we are calling
		String methodSignature = joinPoint.getSignature().toShortString();
		log.info("=====> Before calling method: "+methodSignature);

		//display the arguments to the method
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			log.info("=====> Arguments: " + arg.toString());
		}
	}

	//add @AfterReturning
	@AfterReturning(pointcut = "forSortAlgorithmPackage() || forServiceLayer() || forDAOLayer()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		//display method we are returning from
		String methodSignature = joinPoint.getSignature().toShortString();
		log.info("<===== After returning from method: " + methodSignature);

		//display data we are returning
		log.info( "<===== Result: " + result);
	}

}
