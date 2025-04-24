package com.acts.fruits;

public class Apple implements Comparable<Apple>{
	private int weight;
	private String color;
	private String taste;
	
	
	public Apple() {
		super();
	}

	public Apple(int weight, String color, String taste) {
		super();
		this.weight = weight;
		this.color = color;
		this.taste = taste;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	@Override
	public String toString() {
		return "Apple [weight=" + weight + ", color=" + color + ", taste=" + taste + "]";
	}

	@Override
	public int compareTo(Apple apple) {
		return this.getColor().compareTo(apple.getColor());
	}

}
