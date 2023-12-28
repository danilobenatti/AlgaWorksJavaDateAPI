package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Rental {
	
	private Person person;
	private Car car;
	private LocalDateTime timeOfRent;
	private LocalDateTime expectedReturnDate;
	private LocalDateTime registeredReturnDate;
	
	public Rental(Person person, Car car, LocalDateTime timeOfRent,
			LocalDateTime expectedReturnDate) {
		this.person = person;
		this.car = car;
		this.timeOfRent = timeOfRent;
		this.expectedReturnDate = expectedReturnDate;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("dd/MM/yyy HH:mm", new Locale("pt", "BR"));
		return new StringBuilder().append("\n>>>>> # RentCar S/A # <<<<<")
				.append("\nClient: ").append(getPerson().getName())
				.append(" - Age1: ")
				.append(this.person.age())
				.append(" - Age2: ")
				.append(this.person.getAge())
				.append("\nVehicule: ").append(getCar().getModel())
				.append("\nMoment of get: ")
				.append(getTimeOfRent().format(formatter))
				.append("\nExpected time for return: ")
				.append(getExpectedReturnDate().format(formatter))
				.append("\n>>>>> # RentCar S/A # <<<<<").toString();
	}
}
