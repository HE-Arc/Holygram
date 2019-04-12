package ch.hearc.holygram.seeders;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.models.Customer;
import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.CustomerRepository;
import ch.hearc.holygram.repositories.UserRepository;

@Component
/**
 * Seeder for cantons
 */
public class CustomerSeeder {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public void run() {

		try {
			// Drop data
			customerRepository.deleteAll();

			// Get user
			Optional<User> user = userRepository.findByUsername("customer");

			// Insert data
			customerRepository.save(new Customer(user.get()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
