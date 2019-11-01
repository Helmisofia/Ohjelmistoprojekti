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
						
			arepository.save(new Action("lämppä"));
			arepository.save(new Action("Kevyt"));
			arepository.save(new Action("hiki"));
			
			log.info("fetch all exercises");
			for (Sport sport : repository.findAll()) {
				log.info(sport.toString());
			}
		};
	}
}