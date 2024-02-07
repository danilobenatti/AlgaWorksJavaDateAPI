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
		
		Person p = new Person();
		p.setName("John");
		p.setBirthday(LocalDate.of(1950, Month.JANUARY, 5));
		
		log.info(() -> String.format("%d years old", age(p)));
		log.info(() -> String.format("%d old", p.getAge()));
		
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
		log.info(() -> rental);
		
	}
	
	private static int age(Person person) {
		return age(getBornDate(person), getDeathDate(person));
	}
	
	private static Date getBornDate(Person person) {
		return Date.from(person.getBirthday()
				.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	private static Date getDeathDate(Person person) {
		if (person.getDeathday() != null) {
			return Date.from(person.getDeathday()
					.atStartOfDay(ZoneId.systemDefault()).toInstant());
		}
		return null;
	}
	
	private static int age(Date birthDay, Date deathDay) {
		ZoneId zoneId = ZoneId.systemDefault();
		if (deathDay == null) {
			return Period
					.between(birthDay.toInstant().atZone(zoneId).toLocalDate(),
							LocalDate.now())
					.getYears();
		}
		if (deathDay.after(birthDay)) {
			return Period
					.between(birthDay.toInstant().atZone(zoneId).toLocalDate(),
							deathDay.toInstant().atZone(zoneId).toLocalDate())
					.getYears();
		}
		return 0;
	}
	
	private static String ticket(Rental rental) {
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("dd/MM/yyy HH:mm", new Locale("pt", "BR"));
		return new StringBuilder().append("\n>>>>> # RentCar S/A # <<<<<")
				.append("\nClient: ").append(rental.getPerson().getName())
				.append(" - Age: ").append(rental.getPerson().getAge())
				.append("\nVehicule: ").append(rental.getCar().getModel())
				.append("\nMoment of get: ")
				.append(rental.getTimeOfRent().format(formatter))
				.append("\nExpected time for return: ")
				.append(rental.getExpectedReturnDate().format(formatter))
				.append("\n>>>>> # RentCar S/A # <<<<<").toString();
	}
	
}
