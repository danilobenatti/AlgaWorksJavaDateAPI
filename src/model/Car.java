package model;

import java.time.Year;

public class Car {
	
	private String model;
	private double value;
	private Year year;
	
	public Car() {
	}
	
	public Car(String model, double value, Year year) {
		this.model = model;
		this.value = value;
		this.year = year;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public Year getYear() {
		return year;
	}
	
	public void setYear(Year year) {
		this.year = year;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [model=");
		builder.append(model);
		builder.append(", value=");
		builder.append(value);
		builder.append(", year=");
		builder.append(year);
		builder.append("]");
		return builder.toString();
	}
	
}
