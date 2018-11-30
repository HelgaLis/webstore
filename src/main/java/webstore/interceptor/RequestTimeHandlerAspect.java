package webstore.interceptor;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class RequestTimeHandlerAspect {
	private static final Logger LOGGER = Logger.getLogger(RequestTimeHandlerAspect.class); 
	@Around("execution(* webstore.controller.CustomerController.*(..))")
	public void requestTimeLog(ProceedingJoinPoint point){
		long startTime = System.currentTimeMillis();
		try {
			point.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime =System.currentTimeMillis();
		LOGGER.info(String.format("Aspect. %s ms processed request %s", (endTime - startTime),point.getSignature()));
	}
}
