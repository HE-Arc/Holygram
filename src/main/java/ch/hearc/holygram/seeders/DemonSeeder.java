package ch.hearc.holygram.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.accessors.DemonRepository;

@Component
/**
 * Seeder for demons
 * @author Seg
 *
 */
public class DemonSeeder {

	@EventListener
	public void handleContextRefresh(ContextRefreshedEvent event) {
		this.run();
	}

	@Autowired
	private DemonRepository demonRepository;

	public void run() {

		// Drop data
		demonRepository.deleteAll();

		// Insert data
		
	}
}
