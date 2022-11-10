package com.af.fr.projectOfferTechnical.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.af.fr.projectOfferTechnical.model.User;
import org.aspectj.lang.ProceedingJoinPoint;


@Aspect
@Order( value = 1)
@EnableAspectJAutoProxy
@Component
public class LogAspect {
	
	private long t1, t2;
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Pointcut("execution(* com.af.fr.projectOfferTechnical.service.UserService.findUserById(..))")
	public void logFindUserById() {}
	
	@Pointcut("execution(* com.af.fr.projectOfferTechnical.service.UserService.logAddUser(..))")
	public void logAddUser() {}
	
	@Around("logFindUserById(),logAddUser()")
	public void aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("--------------------------------------------------------");
		logger.info("Before the method " + proceedingJoinPoint.getSignature().getName() + " starts. (Signature : " + proceedingJoinPoint.getSignature() + ")");
		
		Object[] args = proceedingJoinPoint.getArgs();
		
		if( args[0].getClass().isPrimitive() ) {
			logger.info("Input : " + args[0]);
		} else {
			logger.info("Input : " + args[0].toString());
		}
		
		System.out.println("--------------------------------------------------------");
		
		t1 = System.currentTimeMillis();
		
		User result = new User();
		
		result = (User) proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
		
		System.out.println("--------------------------------------------------------");
		logger.info("After the method " + proceedingJoinPoint.getSignature().getName() + " is finished. (Signature : " + proceedingJoinPoint.getSignature() + ")");
		logger.info("Output : " + result.toString());
		
		t2 = System.currentTimeMillis();
		
		logger.info("The method is finished in " + (t2-t1) + " ms.");
		System.out.println("--------------------------------------------------------");
		
	}
}
