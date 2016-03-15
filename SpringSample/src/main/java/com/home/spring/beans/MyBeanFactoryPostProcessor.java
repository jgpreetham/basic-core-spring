package com.home.spring.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author preetham
 *
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
		 System.out.println("MyBeanFactoryPostProcessor ran and the beanPostProcessorCount is "+ beanFactory.getBeanPostProcessorCount());
		
	}

}
