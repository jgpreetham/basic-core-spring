package com.home.spring.beans;

import java.util.List;

/**
 * @author preetham
 *
 */
public class Dog{

	//used for setter,constructor injection
	private String name;
	private int age;
	
	//user for object injection, autowireByName
	private Food sweetFood;
	private Food spicyFood;
	
	//used for injecting collections,bean definition inheritance
	private List<Food> foods;
	
	
	
	public Dog()
	{
		System.out.println("Dog object created");
	}
	
	public Dog(String name, int age)
	{
		System.out.println("Dog object created with constructor with name= " + name + " and age= "+ age);
		this.name=name;
		this.age=age;
				
	}
	
	public String getName() {
		System.out.println("Dog getName "+ name);
		return name;
	}
	public void setName(String name) {
		System.out.println("Dog setName "+ name);
		this.name = name;
	}
	public int getAge() {
		System.out.println("Dog getAge "+ age);
		return age;
	}
	public void setAge(int age) {
		System.out.println("Dog setAge "+ age);
		this.age = age;
	}
	
	public Food getSweetFood() {
		System.out.println("Dog getSweetFood called");
		return sweetFood;
	}

	public void setSweetFood(Food sweetFood) {
		System.out.println("Dog setSweetFood called");
		this.sweetFood = sweetFood;
	}

	public Food getSpicyFood() {
		System.out.println("Dog getSpicyFood called");
		return spicyFood;
	}

	public void setSpicyFood(Food spicyFood) {
		System.out.println("Dog setSpicyFood called");
		this.spicyFood = spicyFood;
	}

	
	
	public List<Food> getFoods() {
		System.out.println("Dog getFoods called");
		return foods;
	}

	public void setFoods(List<Food> foods) {
		System.out.println("Dog setFoods called");
		this.foods = foods;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", sweetFood="
				+ sweetFood + ", spicyFood=" + spicyFood + ", foods=" + foods
				+ "]";
	}

	

	

	
	
	
	
	
}
