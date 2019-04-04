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
	@Autowired
	private RoleRepository roleRepository;

	public void run() {
		
		//Prepare role
		Role role = roleRepository.findByNameRole("CUSTOMER");
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);

		// Drop data
		customerRepository.deleteAll();

		// Insert data
		Customer customer = new Customer("customer", "1234", "customer@holygram.com", null);
		customer.setRoles(roles);
		customerRepository.save(customer);

	}
}
