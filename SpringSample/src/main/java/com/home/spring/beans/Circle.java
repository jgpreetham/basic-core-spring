package com.home.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

//@Compnonent is similar to defining bean in spring.xml 
/*<bean id="circle" class="com.home.spring.beans.Circle">

</bean>*/


/**
 * @author preetham
 *
 */
@Component
public class Circle {

	//bean id="center" from spring.xml will be injected here 
	/*<bean id="circle" class="com.home.spring.beans.Circle" autowire="byType or autowire="byName">*/
	@Autowired
	private Point center;
	
	//bean id="pointA" from spring.xml will be injected here because it has qualifier="circleRelated"
	@Autowired
	@Qualifier("circleRelated")
	private Point testQualifier;
	
	//<bean id="messageSource" is injected here
	@Autowired
	private MessageSource messageSource;
	
	public Point getCenter() {
		System.out.println("Circle getCenter is called ");
		return center;
	}


	public void setCenter(Point center) {
		System.out.println("Circle with @Required annotation setCenter is called ");
		this.center = center;
	}


	@Override
	public String toString() {
		return "Circle [center=" + center + ", testQualifier=" + testQualifier
				+ "]";
	}


	public Point getTestQualifier() {
		System.out.println("Circle getTestQualifier called ");
		return testQualifier;
	}


	public void setTestQualifier(Point testQualifier) {
		System.out.println("Circle setTestQualifier called ");
		this.testQualifier = testQualifier;
	}


	public MessageSource getMessageSource() {
		System.out.println("Circle getMessageSource called");
		return messageSource;
	}


	public void setMessageSource(MessageSource messageSource) {
		System.out.println("Circle setMessageSource called");
		this.messageSource = messageSource;
	}

}
