package com.af.fr.projectOfferTechnical.tests;

import java.util.Date;
import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.af.fr.projectOfferTechnical.model.User;

import org.aspectj.lang.JoinPoint;


@Aspect
@Order( value = 0)
@EnableAspectJAutoProxy
@Component
public class TestsUserService {
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Pointcut("execution(* com.af.fr.projectOfferTechnical.service.UserService.findUserById(..))")
	public void logFindUserById() {}
	
	@Pointcut("execution(* com.af.fr.projectOfferTechnical.service.UserService.logAddUser(..))")
	public void logAddUser() {}
	
	@Before("logFindUserById()")
	public void testLogFindUserById(JoinPoint joinPoint) throws Throwable {
		System.out.println("--------------------------------------------------------");
		logger.info("Tests before the method " + joinPoint.getSignature().getName() );
		System.out.println("--------------------------------------------------------");
	}
	
	@Before("logAddUser()")
	public void testLogAddUser(JoinPoint joinPoint) throws Throwable {
		System.out.println("--------------------------------------------------------");
		logger.info("Tests before the method " + joinPoint.getSignature().getName() );
		
		Object[] args = joinPoint.getArgs();
		
		logger.info("Input : " + args[0].toString());
		
		User user = (User) args[0];
		
		if((new Date().getYear() - user.getBirthdate().getYear()) < 18 ) {
			throw new Exception("Stop");
		}
		
		if(user.getCountryOfResidence() != "FRANCE") {
			throw new Exception("Stop");
		}
		
		System.out.println("--------------------------------------------------------");
		
	}
}
