package examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Car;
import model.Person;
import model.Rental;

public class Principal {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(Principal.class.getName(),
				"./src/resources/log4j2.properties");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 1958);
		calendar.set(Calendar.MONTH, 4);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date bornDate = calendar.getTime();
		log.info(() -> String.format("Born date: %s", bornDate));
		log.info(() -> String.format("%d years", age(bornDate)));
		
		Person p = new Person("John", LocalDate.of(1958, Month.APRIL, 1));
		log.info(() -> String.format("%d years", age(p.getBirthday())));
		
		Car c1 = new Car("X1", 50000, Year.of(1995));
		Car c2 = new Car("OP", 20000, Year.of(2001));
		Car c3 = new Car("KL", 10000, Year.parse("2008"));
		List<Car> cars = Arrays.asList(c1, c2, c3);
		cars.forEach(c -> log.info(c.toString()));
		cars.stream().filter(c -> c.getYear().isAfter(Year.of(2000)))
				.forEach(c -> log.info(c));
		
		Rental rental = new Rental();
		rental.setPerson(p);
		rental.setCar(c1);
		rental.setTimeOfRent(LocalDateTime.of(LocalDate.now(),
				LocalTime.of(LocalTime.now().getHour(), 0)));
		rental.setExpectedReturnDate(
				LocalDateTime.now().plusDays(3).plusHours(2));
		log.info(() -> ticket(rental));
		
	}
	
	private static int age(Date bornDate) {
		return Period.between(bornDate.toInstant()
				.atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now())
				.getYears();
	}
	
	private static int age(LocalDate bornDate) {
		return Period.between(bornDate, LocalDate.now()).getYears();
	}
	
	private static String ticket(Rental rental) {
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("dd/MM/yyy HH:mm", new Locale("pt", "BR"));
		StringBuilder b = new StringBuilder();
		b.append("\n>>>>> # RentCar S/A # <<<<<");
		b.append("\nClient: ");
		b.append(rental.getPerson().getName());
		b.append("\nVehicule: ");
		b.append(rental.getCar().getModel());
		b.append("\nMoment of get: ");
		b.append(rental.getTimeOfRent().format(formatter));
		b.append("\nExpected time for return: ");
		b.append(rental.getExpectedReturnDate().format(formatter));
		b.append("\n>>>>> # RentCar S/A # <<<<<");
		return b.toString();
	}
	
}
