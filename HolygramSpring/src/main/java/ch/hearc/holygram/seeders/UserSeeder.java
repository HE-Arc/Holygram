package ch.hearc.holygram.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.models.Role;
import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.RoleRepository;
import ch.hearc.holygram.repositories.UserRepository;

@Component
/**
 * Seeder for cantons
 */
public class UserSeeder {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public void run() {

		try {
			// Get Customer Role
			Role customerRole = roleRepository.findByName("CUSTOMER");
			
			User newCustomer = new User("customer", "1234", "customer@email.com", customerRole);
			userRepository.save(newCustomer);

			// Get Exorcist Role
			Role exorcistRole = roleRepository.findByName("EXORCIST");

			User newExorcist = new User("exorcist", "1234", "exorcist@email.com", exorcistRole);
			userRepository.save(newExorcist);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
