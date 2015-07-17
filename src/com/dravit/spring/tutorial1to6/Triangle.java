package com.dravit.spring.tutorial1to6;

public class Triangle {
	private String type;
	private String constructorType;
	private int height;
	
	public Triangle(String constructorType) {
		this.constructorType = constructorType;
	}
	
	public Triangle(String constructorType, int height) {
		this.constructorType = constructorType;
		this.height = height;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	public void draw() {
		System.out.println(getType() + " Triangle Drawn " + this.constructorType + "of height "+ this.height + "cm.");
	}
}
