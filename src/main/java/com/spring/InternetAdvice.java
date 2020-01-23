package com.spring;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.cglib.proxy.MethodProxy;

public class InternetAdvice implements MethodBeforeAdvice, AfterReturningAdvice,ThrowsAdvice,MethodInterceptor {
	private CafeOwner cafeOwner;
	public void before(Method argo0, Object[] arg1, Object arg2) throws Throwable{
		this.getCafeOwner().LogInTime();
	}
	public void setCafeOwner(CafeOwner cafeOwner) {
		this.cafeOwner=cafeOwner;
	}
	public CafeOwner getCafeOwner() {
		return cafeOwner;
	}
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		
		return null;
	}
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		this.getCafeOwner().IssueUsageBill();
		this.getCafeOwner().LogOutTime();
	}
	
	public void afterThrowing(Throwable throwable) {
		System.out.println("2 throws");
		this.getCafeOwner().cancelBill();
	}
	
	public Object invoke(MethodInvocation method) throws Throwable{
		System.out.println("Allocate a system to customer");
		method.proceed();
		System.out.println("Deallocate the system");
		return null;
	}
}
