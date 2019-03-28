package ch.hearc.holygram.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
/**
 * Seeder for cantons
 */
public class BaseSeeder {

	@Autowired
	private CantonSeeder cs;
	
	@Autowired
	private ReligionSeeder rs;
	
	@Autowired
	private ExorcistSeeder es;
	
	@Autowired
	private DemonSeeder ds;

	@EventListener
	public void seed(ContextRefreshedEvent event) {
		// Seed canton
		cs.run();

		// Seed religion
		rs.run();

		// Seed exorcist
		es.run();

		// Seed demon
		ds.run();
	}
}
