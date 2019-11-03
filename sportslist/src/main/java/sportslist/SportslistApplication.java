package sportslist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sportslist.domain.Sport;
import sportslist.domain.SportslistRepository;
import sportslist.domain.Action;
import sportslist.domain.ActionRepository;

@SpringBootApplication
public class SportslistApplication {
	private static final Logger log = LoggerFactory.getLogger(SportslistApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SportslistApplication.class, args);
	}
	@Bean
	public CommandLineRunner sportslistDemo(SportslistRepository repository, ActionRepository arepository) {
		return (args) -> {
			log.info("save a couple of exercises");
						
			arepository.save(new Action("Warm-up"));
			arepository.save(new Action("Light sport"));
			arepository.save(new Action("Sweat exercise"));
			arepository.save(new Action("Interval"));
			
			repository.save(new Sport("Mäkelänrinne", "Uinti", "2019-11-06", 120, arepository.findByName("Light sport").get(0)));
			repository.save(new Sport("Tripla", "Kuntosali", "2019-11-12", 60, arepository.findByName("Sweat exercise").get(0)));
			repository.save(new Sport("Pasila", "Aamulenkki", "2019-09-08", 30, arepository.findByName("Interval").get(0)));
			
			log.info("fetch all exercises");
			for (Sport sport : repository.findAll()) {
				log.info(sport.toString());
			}
		};
	}
}