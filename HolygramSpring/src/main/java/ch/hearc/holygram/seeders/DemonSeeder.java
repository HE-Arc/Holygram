package ch.hearc.holygram.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.accessors.DemonRepository;
import ch.hearc.holygram.accessors.ReligionRepository;
import ch.hearc.holygram.models.Demon;
import ch.hearc.holygram.models.Religion;

@Component
/**
 * Seeder for demons
 */
public class DemonSeeder {

	@Autowired
	private DemonRepository demonRepository;

	@Autowired
	private ReligionRepository religionRepository;

	public void run() {

		// Drop data
		demonRepository.deleteAll();

		// Get religions
		Iterable<Religion> religions = religionRepository.findAll();

		System.out.println(religions);

		// Insert data
		for (Religion r : religions) {
			demonRepository.save(new Demon("Ghost", r));
		}

		System.out.println(demonRepository.findAll());
	}
}
