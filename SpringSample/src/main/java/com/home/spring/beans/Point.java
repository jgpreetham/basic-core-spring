package com.home.spring.beans;



/**
 * @author preetham
 *
 */
public class Point {

	private int x;
	private int y;
	
	public Point() {
		System.out.println("Point contructor called");
	}
	
	public int getX() {
		System.out.println("Point getX "+ x);
		return x;
	}
	public void setX(int x) {
		System.out.println("Point setX "+ x);
		this.x = x;
	}
	public int getY() {
		System.out.println("Point getY "+ y);
		return y;
	}
	public void setY(int y) {
		System.out.println("Point seYX "+ y);
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
	
	
}
	
	
	
