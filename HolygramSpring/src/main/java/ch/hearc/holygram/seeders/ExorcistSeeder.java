package ch.hearc.holygram.seeders;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.accessors.ExorcistRepository;
import ch.hearc.holygram.accessors.RoleRepository;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.Role;

@Component
/**
 * Seeder for cantons
 */
public class ExorcistSeeder {

	@Autowired
	private ExorcistRepository exorcistRepository;
	@Autowired
	private RoleRepository roleRepository;

	public void run() {
		//Prepare role
		Role role = roleRepository.findByNameRole("EXORCIST");
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);

		// Drop data
		exorcistRepository.deleteAll();

		// Insert data
		Exorcist exorcist = new Exorcist("exorcist", "1234", "exorcist@holygram.com", "", "", "", null);
		exorcist.setRoles(roles);
		exorcistRepository.save(exorcist);

	}
}
