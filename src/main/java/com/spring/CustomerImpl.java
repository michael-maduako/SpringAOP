package com.spring;

public class CustomerImpl implements Customer {
	public void browse() throws Exception{
		System.out.println("Browsing the internet");
		//throw new Exception("Connection Lost");
	}
}
