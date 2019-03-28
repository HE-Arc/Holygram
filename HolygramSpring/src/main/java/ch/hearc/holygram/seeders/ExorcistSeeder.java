package ch.hearc.holygram.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.accessors.ExorcistRepository;
import ch.hearc.holygram.models.Exorcist;

@Component
/**
 * Seeder for cantons
 * @author Seg
 *
 */
public class ExorcistSeeder {

	@EventListener
	public void handleContextRefresh(ContextRefreshedEvent event) {
		this.run();
	}

	@Autowired
	private ExorcistRepository exorcistRepository;

	public void run() {
		
		// Drop data
		exorcistRepository.deleteAll();

		// Insert data
		exorcistRepository.save(new Exorcist("Raphaël", "1234", "raphael@email.com", "", "", "", null));

	}
}
