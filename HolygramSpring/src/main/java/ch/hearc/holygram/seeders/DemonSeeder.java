package ch.hearc.holygram.seeders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.models.Demon;
import ch.hearc.holygram.models.Religion;
import ch.hearc.holygram.repositories.DemonRepository;
import ch.hearc.holygram.repositories.ReligionRepository;

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
		List<Religion> religions = (List<Religion>) religionRepository.findAll();

		List<String> demons = new ArrayList<>();
		demons.add("Ghost");
		demons.add("Djinn");
		demons.add("Vampir");
		demons.add("Troll");
		demons.add("Goul");
		demons.add("Spirit");
		demons.add("Gnom");
		demons.add("Lepprechaun");

		// Insert data
		for (int i = 0; i < 8; ++i) {
			demonRepository.save(new Demon(demons.get(i), religions.get(i)));
		}
		demons.add("Satan");
		demonRepository.save(new Demon("Satan", religions.get(0)));
	}
}
