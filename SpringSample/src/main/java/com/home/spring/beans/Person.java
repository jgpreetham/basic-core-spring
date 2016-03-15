package com.home.spring.beans;

/**
 * @author preetham
 *
 */
public class Person {
	private String name;

	public Person() {
		System.out.println("Person Constructor called");
	}
	public String getName() {
		System.out.println("Person getName called "+ name);
		return name;
	}

	public void setName(String name) {
		System.out.println("Person setName called "+ name);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	

}
