package com.home.spring.beans;

/**
 * @author preetham
 *
 */
public class Food {

	private String taste;
	private String quality;
	
	
	public Food()
	{
		System.out.println("Food constructor called");
	}
	public String getTaste() {
		System.out.println("getTaste is "+ taste);
		return taste;
	}
	public void setTaste(String taste) {
		System.out.println("setTaste "+ taste);
		this.taste = taste;
	}
	public String getQuality() {
		System.out.println("getQuality is "+ quality);
		return quality;
	}
	public void setQuality(String quality) {
		System.out.println("setQuality is "+ quality);
		this.quality = quality;
	}
	@Override
	public String toString() {
		return "Food [taste=" + taste + ", quality=" + quality + "]";
	}

	
	
}
