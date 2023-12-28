package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	
	private String name;
	private LocalDate birthday;
	
	static int age(Date bornDate) {
		return Period.between(bornDate.toInstant()
				.atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now())
				.getYears();
	}
	
	public int age() {
		return Period.between(this.birthday, LocalDate.now()).getYears();
	}
	
	public int getAge() {
		return LocalDate.now().minusYears(this.birthday.getYear()).getYear();
	}
	
}
