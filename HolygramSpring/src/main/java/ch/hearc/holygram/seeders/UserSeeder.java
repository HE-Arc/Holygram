package ch.hearc.holygram.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.models.Canton;
import ch.hearc.holygram.models.Customer;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.CantonRepository;
import ch.hearc.holygram.repositories.CustomerRepository;
import ch.hearc.holygram.repositories.ExorcistRepository;
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
	private CantonRepository cantonRepository;

	private static final String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas eu nisi quis ante interdum vestibulum. Cras semper lacus non urna ultricies, eu semper dui rutrum. Etiam id odio at dui bibendum varius nec vitae justo. Sed varius luctus tristique. Morbi lobortis, massa vel scelerisque lacinia, lorem mi imperdiet diam, ac posuere nunc ipsum sit amet mi. Nullam in bibendum nunc, vitae aliquet turpis. Etiam in mattis dolor.\n";

	public void run() {

		try {
			userRepository.deleteAll();
			customerRepository.deleteAll();
			exorcistRepository.deleteAll();

			addCustomer();
			addExorcist();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addExorcist() throws Exception {
		User newExorcist = new User("exorcist", "1234", "exorcist@email.com", RoleSeeder.exorcistRole);
		userRepository.save(newExorcist);

		Canton canton = cantonRepository.findById(10l).get();

		Exorcist e = new Exorcist(newExorcist, lorem, "phone", canton);
		exorcistRepository.save(e);
	}

	private void addCustomer() throws Exception {
		User newCustomer = new User("customer", "1234", "customer@email.com", RoleSeeder.customerRole);
		userRepository.save(newCustomer);
		
		Customer c = new Customer(newCustomer);
		customerRepository.save(c);
	}
}
