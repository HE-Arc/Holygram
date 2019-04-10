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
	private ExorcistRepository exorcistRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private RoleRepository roleRepository;

	public void run() {

		try {
			// Get Customer Role
			Role customerRole = roleRepository.findByName("CUSTOMER");

			User newCustomer = userRepository.save(new User("customer", "1234", "customer@email.com", customerRole));

			// Drop data
			customerRepository.deleteAll();

			// Insert data
			customerRepository.save(new Customer(newCustomer));
			
			// Get Exorcist Role
			Role exorcistRole = roleRepository.findByName("CUSTOMER");

			User newExorcist = userRepository.save(new User("customer", "1234", "customer@email.com", exorcistRole));

			// Drop data
			exorcistRepository.deleteAll();

			// Insert data
			String description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
			exorcistRepository.save(new Exorcist(newExorcist, description, ""));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
