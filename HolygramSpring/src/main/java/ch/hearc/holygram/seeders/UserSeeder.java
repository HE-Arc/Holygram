package ch.hearc.holygram.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.models.Customer;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.Role;
import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.CustomerRepository;
import ch.hearc.holygram.repositories.ExorcistRepository;
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
	private CustomerRepository customerRepository;

	@Autowired
	private ExorcistRepository exorcistRepository;

	@Autowired
	private RoleRepository roleRepository;

	public void run() {

		try {
			String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas eu nisi quis ante interdum vestibulum. Cras semper lacus non urna ultricies, eu semper dui rutrum. Etiam id odio at dui bibendum varius nec vitae justo. Sed varius luctus tristique. Morbi lobortis, massa vel scelerisque lacinia, lorem mi imperdiet diam, ac posuere nunc ipsum sit amet mi. Nullam in bibendum nunc, vitae aliquet turpis. Etiam in mattis dolor.\n" + 
					"\n" + 
					"Nulla commodo dictum orci, eu tempus metus sagittis in. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Integer tincidunt magna id venenatis pretium. Praesent quis fermentum ipsum, a cursus libero. Ut enim ex, mollis sit amet ultrices non, tristique quis ante. Aenean pretium, libero eu faucibus volutpat, arcu magna facilisis tellus, a ultrices odio lacus a sem. Ut efficitur augue nec dui tincidunt lobortis. Nam risus metus, facilisis in accumsan id, rhoncus at justo. Curabitur a ultricies quam. Maecenas venenatis suscipit nunc in tincidunt. Ut vel ante nisi. Ut eget sodales dolor. Maecenas bibendum, mi sed euismod sodales, eros quam pharetra orci, sit amet aliquet eros tellus quis augue. Fusce tincidunt felis fringilla feugiat dictum.";
			
			userRepository.deleteAll();
			Role customerRole = roleRepository.findByName("CUSTOMER");
			Role exorcistRole = roleRepository.findByName("EXORCIST");

			User newCustomer = new User("customer", "1234", "customer@email.com", customerRole);
			Customer c = new Customer();
			customerRepository.save(c);
			newCustomer.setCustomer(c);
			userRepository.save(newCustomer);

			User newExorcist = new User("exorcist", "1234", "exorcist@email.com", exorcistRole);
			Exorcist e = new Exorcist(lorem, "phone");
			exorcistRepository.save(e);
			newExorcist.setExorcist(e);
			userRepository.save(newExorcist);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
