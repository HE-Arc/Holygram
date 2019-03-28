package ch.hearc.holygram.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.accessors.ReligionRepository;
import ch.hearc.holygram.models.Religion;

@Component
/**
 * Seeder for religions
 */
public class ReligionSeeder {

	@Autowired
	private ReligionRepository religionRepository;

	public void run() {

		// Drop data
		religionRepository.deleteAll();

		// Insert data
		religionRepository.save(new Religion("Christianity"));
		religionRepository.save(new Religion("Hinduism"));
		religionRepository.save(new Religion("Islam"));
		religionRepository.save(new Religion("Judaism"));
		religionRepository.save(new Religion("Taoism"));
		religionRepository.save(new Religion("Orthodox"));
		religionRepository.save(new Religion("Buddhism"));
		religionRepository.save(new Religion("Folk religion"));
	}
}
