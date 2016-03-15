package com.home.spring.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author preetham
 *
 */
public class Cat implements InitializingBean,DisposableBean,BeanNameAware{

	// autoWireByType
	private Person owner;
	private String beanName;

	
	public Cat() {
		System.out.println("Cat constructor called");
	}
	public Cat(Person owner) {
		System.out.println("Cat object created with constructor with owner = "
				+ owner);
		this.owner = owner;
	}

	
	public Person getOwner() {
		System.out.println("Cat getOwner called");
		return owner;
	}

	public void setOwner(Person owner) {
		System.out.println("Cat setOwner called");
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "Cat [owner=" + owner + "]";
	}

	public void init()
	{
		System.out.println("Init method called for Cat");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean's afterPropertiesSet() method called for Cat for bean= "+beanName);
		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean's destroy method called for Cat for bean= "+ beanName);
		
	}
	
	public void myInit()
	{
		System.out.println("My default init method is called for Cat. You can override default init by defining init-method=\"yourNewInitMethod()\" in the bean defnition");
	}
	
	public void myDestroy()
	{
		System.out.println("My default destroy method is called for Cat. You can override default destroy by defining destroy-method=\"yourNewDestroyMethod()\" in the bean defnition");
	}
	@Override
	public void setBeanName(String beanName) {
		System.out.println("bean name aware's setBean name called "+ beanName);
		this.beanName=beanName;
		
	}
	
	public String getBeanName()
	{
		return this.beanName;
	}
	
}
