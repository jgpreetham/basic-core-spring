package com.home.spring.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author preetham
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		
		System.out.println("MyBeanPostProcessor ran and do postProcessAfterInitialization for bean "+ beanName);
		if(bean instanceof Cat)
		{
			System.out.println("Adding string \"Processed\" to bean name in postProcessAfterInitialization for Cat bean "+ beanName);
			Cat c = (Cat) bean;
			c.setBeanName(beanName+"Processed");
		}
		return bean;
		
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		
		System.out.println("MyBeanPostProcessor ran and do postProcessBeforeInitialization for bean "+ beanName);
		return bean;
	}

}
