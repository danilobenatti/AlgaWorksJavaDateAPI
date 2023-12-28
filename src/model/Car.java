package model;

import java.time.Year;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	
	private String model;
	private double value;
	private Year year;
	
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
