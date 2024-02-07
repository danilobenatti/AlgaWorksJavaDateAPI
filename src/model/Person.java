package model;

import java.time.LocalDate;
import java.time.Period;

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
	private LocalDate deathday;
	
	public Integer getAge() {
		return getAge(this.birthday, this.deathday);
	}
	
	private static Integer getAge(LocalDate birthDate, LocalDate deathDay) {
		if (deathDay == null) {
			return Period.between(birthDate, LocalDate.now()).getYears();
		}
		if (deathDay.isAfter(birthDate)) {
			return Period.between(birthDate, deathDay).getYears();
		}
		return null;
	}
}
