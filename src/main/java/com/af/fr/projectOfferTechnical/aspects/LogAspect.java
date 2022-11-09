package com.af.fr.projectOfferTechnical.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;


@Aspect
@EnableAspectJAutoProxy
@Component
public class LogAspect {
	
	private long t1, t2;
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	// Ne marche pas
//	@Pointcut("call(* com.af.fr.projectOfferTechnical.service.*.*(..))")
	// Marche
	@Pointcut("execution(* com.af.fr.projectOfferTechnical.service.*.*(..))")
	public void log() {}
	
	
//	@Around("log()")
//	public void aroundMethod(JoinPoint thisJoinPoint) {
//		logger.info("aroundMethod " + thisJoinPoint.getSignature());
//	}

	@Before("log()")
	public void beforeMethod(JoinPoint thisJoinPoint) {
		System.out.println("--------------------------------------------------------");
		logger.info("Before the method " + thisJoinPoint.getSignature() + " starts.");
		
//		Long i = (Long) thisJoinPoint.getTarget();
//		
//		
//		logger.info("The inputs are " + i);
		System.out.println("--------------------------------------------------------");
		
		t1 = System.currentTimeMillis();
		
	}
	
	@After("log()")
	public void afterMethod(JoinPoint thisJoinPoint) {
		System.out.println("--------------------------------------------------------");
		logger.info("After the method " + thisJoinPoint.getSignature() + " is finished.");
		
		t2 = System.currentTimeMillis();
		
		logger.info("The method is finished in " + (t2-t1) + " ms.");
		System.out.println("--------------------------------------------------------");
	}
	
}
