package ch.hearc.holygram.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.models.Canton;
import ch.hearc.holygram.models.Customer;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.Role;
import ch.hearc.holygram.models.Service;
import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.CantonRepository;
import ch.hearc.holygram.repositories.CustomerRepository;
import ch.hearc.holygram.repositories.DemonRepository;
import ch.hearc.holygram.repositories.ExorcistRepository;
import ch.hearc.holygram.repositories.RoleRepository;
import ch.hearc.holygram.repositories.ServiceRepository;
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

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private DemonRepository demonRepository;

	private static final String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas eu nisi quis ante interdum vestibulum. Cras semper lacus non urna ultricies, eu semper dui rutrum. Etiam id odio at dui bibendum varius nec vitae justo. Sed varius luctus tristique. Morbi lobortis, massa vel scelerisque lacinia, lorem mi imperdiet diam, ac posuere nunc ipsum sit amet mi. Nullam in bibendum nunc, vitae aliquet turpis. Etiam in mattis dolor.\n";


	public void run() {

		try {
			userRepository.deleteAll();

			addUser();
			addExorcist();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addExorcist() throws Exception {
		User newExorcist = new User("exorcist", "1234", "exorcist@email.com", RoleSeeder.exorcistRole);

		Canton canton = cantonRepository.findById(10l).get();

		Exorcist e = new Exorcist(lorem, "phone", canton);
		exorcistRepository.save(e);
		newExorcist.setExorcist(e);
		userRepository.save(newExorcist);

		serviceRepository.save(new Service(e, demonRepository.findById(1l).get(), 4.2f));
		serviceRepository.save(new Service(e, demonRepository.findById(3l).get(), 2.4f));
	}

	private void addUser() throws Exception {
		User newCustomer = new User("customer", "1234", "customer@email.com", RoleSeeder.customerRole);
		Customer c = new Customer();
		customerRepository.save(c);
		newCustomer.setCustomer(c);
		userRepository.save(newCustomer);
	}
}
