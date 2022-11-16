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

/**
 * Class for log inputs and outputs of each call
 * @author escan
 */
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
	
	
	/**
	 * Method call when method logFindUserById() or logAddUser() are executed
	 * @param proceedingJoinPoint
	 * @throws Throwable
	 */
	@Around("logFindUserById(),logAddUser()")
	public void aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("--------------------------------------------------------");
		logger.info("Before the method " + proceedingJoinPoint.getSignature().getName() + " starts. (Signature : " + proceedingJoinPoint.getSignature() + ")");
		
		// Argument recovery
		Object[] args = proceedingJoinPoint.getArgs();
		
		// Test args[0] is primitive
		if( args[0].getClass().isPrimitive() ) {
			logger.info("Input : " + args[0]);
		} else {
			logger.info("Input : " + args[0].toString());
		}
		
		System.out.println("--------------------------------------------------------");
		
		// Retrieves the elapsed time in ms
		t1 = System.currentTimeMillis();
		
		// Runs the method and gets its return
		User result = new User();
		result = (User) proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
		
		System.out.println("--------------------------------------------------------");
		logger.info("After the method " + proceedingJoinPoint.getSignature().getName() + " is finished. (Signature : " + proceedingJoinPoint.getSignature() + ")");
		logger.info("Output : " + result.toString());
		
		// Retrieves the elapsed time in ms
		t2 = System.currentTimeMillis();
		
		// Give the elapsed time in ms
		logger.info("The method is finished in " + (t2-t1) + " ms.");
		System.out.println("--------------------------------------------------------");
		
	}
}
