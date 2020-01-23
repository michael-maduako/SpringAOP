package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	ApplicationContext ctx= new ClassPathXmlApplicationContext("spring.xml");
    	Customer customer= (Customer)ctx.getBean("customerProxy");
    	customer.browse();
    }
}
