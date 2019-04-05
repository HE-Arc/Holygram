package ch.hearc.holygram.seeders;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.accessors.ExorcistRepository;
import ch.hearc.holygram.accessors.RoleRepository;
import ch.hearc.holygram.models.Role;
import ch.hearc.holygram.accessors.UserRepository;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.User;

@Component
/**
 * Seeder for cantons
 */
public class ExorcistSeeder {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ExorcistRepository exorcistRepository;

	public void run() {

/*		// Drop data
		exorcistRepository.deleteAll();

		// Insert data
		Exorcist exorcist = new Exorcist("exorcist", "1234", "exorcist@holygram.com", "", "", "", null);
		exorcist.setRoles(roles);
		exorcistRepository.save(exorcist);*/

		// Add new user
		User newUser;
		try {
			newUser = userRepository.save(new User("Raphaël", "1234", "raphael@email.com"));
			
			// Drop data
			exorcistRepository.deleteAll();

			// Insert data
			exorcistRepository.save(new Exorcist(newUser, "", ""));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
