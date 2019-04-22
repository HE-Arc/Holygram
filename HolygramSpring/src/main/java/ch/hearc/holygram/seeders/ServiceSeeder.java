package ch.hearc.holygram.seeders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.models.Demon;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.Service;
import ch.hearc.holygram.repositories.DemonRepository;
import ch.hearc.holygram.repositories.ExorcistRepository;
import ch.hearc.holygram.repositories.ServiceRepository;

@Component
/**
 * Seeder for demons
 */
public class ServiceSeeder {

	@Autowired
	private DemonRepository demonRepository;

	@Autowired
	private ExorcistRepository exorcistRepository;

	@Autowired
	private ServiceRepository serviceRepository;

	public void run() {

		// Drop data
		serviceRepository.deleteAll();

		// Get demons
		List<Demon> demons = (List<Demon>) demonRepository.findAll();

		// Get demons
		List<Exorcist> exorcists = (List<Exorcist>) exorcistRepository.findAll();

		// Debug
		for (int i = 0; i < exorcists.size(); i++) {
			Exorcist e = exorcists.get(i);
			Demon d = demons.get(i % demons.size());
			Service s = new Service(e, d, i);
			serviceRepository.save(s);
		}
	}
}
