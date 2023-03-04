package model;

import java.time.LocalDateTime;

public class Rental {
	
	private Person person;
	private Car car;
	private LocalDateTime timeOfRent;
	private LocalDateTime expectedReturnDate;
	private LocalDateTime registeredReturnDate;
	
	public Rental() {
	}
	
	public Rental(Person person, Car car, LocalDateTime timeOfRent,
			LocalDateTime expectedReturnDate) {
		this.person = person;
		this.car = car;
		this.timeOfRent = timeOfRent;
		this.expectedReturnDate = expectedReturnDate;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Car getCar() {
		return car;
	}
	
	public void setCar(Car car) {
		this.car = car;
	}
	
	public LocalDateTime getTimeOfRent() {
		return timeOfRent;
	}
	
	public void setTimeOfRent(LocalDateTime timeOfRent) {
		this.timeOfRent = timeOfRent;
	}
	
	public LocalDateTime getExpectedReturnDate() {
		return expectedReturnDate;
	}
	
	public void setExpectedReturnDate(LocalDateTime expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}
	
	public LocalDateTime getRegisteredReturnDate() {
		return registeredReturnDate;
	}
	
	public void setRegisteredReturnDate(LocalDateTime registeredReturnDate) {
		this.registeredReturnDate = registeredReturnDate;
	}
	
}
