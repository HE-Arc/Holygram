package ch.hearc.holygram.seeders;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.accessors.CustomerRepository;
import ch.hearc.holygram.accessors.RoleRepository;
import ch.hearc.holygram.models.Customer;
import ch.hearc.holygram.models.Role;

@Component
/**
 * Seeder for cantons
 * @author Seg
 *
 */
public class CustomerSeeder {

	@EventListener
	public void handleContextRefresh(ContextRefreshedEvent event) {
		this.run();
	}

	@Autowired
	private CustomerRepository customerRepository;

	public void run() {
		// Drop data
		customerRepository.deleteAll();

		// Insert data
		//customerRepository.save(new Customer("customer", "1234", "customer@holygram.com", null));

	}
}
