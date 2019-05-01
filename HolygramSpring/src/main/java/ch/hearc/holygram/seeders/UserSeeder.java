package ch.hearc.holygram.seeders;

import ch.hearc.holygram.models.*;
import ch.hearc.holygram.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
/**
 * Seeder for cantons
 */
public class UserSeeder {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ExorcistRepository exorcistRepository;

	@Autowired
	private CantonRepository cantonRepository;

	@Autowired
	private DemonRepository demonRepository;

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private EvaluationRepository evaluationRepository;


	private static final String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas eu nisi quis ante interdum vestibulum. Cras semper lacus non urna ultricies, eu semper dui rutrum. Etiam id odio at dui bibendum varius nec vitae justo. Sed varius luctus tristique. Morbi lobortis, massa vel scelerisque lacinia, lorem mi imperdiet diam, ac posuere nunc ipsum sit amet mi. Nullam in bibendum nunc, vitae aliquet turpis. Etiam in mattis dolor.\n";

	private static Random random = new Random(0);

	public void run() {

		try {
			userRepository.deleteAll();
			customerRepository.deleteAll();
			exorcistRepository.deleteAll();
			serviceRepository.deleteAll();
			evaluationRepository.deleteAll();

			addCustomer();

			for(int i = 0; i < 5; i++)
			{
				addExorcist(i, random.nextInt(10), random.nextInt(10));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addExorcist(int id, int nbServices, int nbEvaluations) throws Exception {

		List<Canton> cantons = (List<Canton>)cantonRepository.findAll();
		List<Demon> demons = (List<Demon>)demonRepository.findAll();

		User u = new User("exorcist" + id, bCryptPasswordEncoder.encode("12345678"), "exorcist" + id + "@email.com",
				RoleSeeder.exorcistRole);

		userRepository.save(u);
		Exorcist e = new Exorcist(u, lorem, "+41 32 123 12 " + id, cantons.get(random.nextInt(cantons.size())));
		exorcistRepository.save(e);

		for (int i = 0; i < nbServices; i++) {
			Demon d = demons.get(random.nextInt(demons.size()));
			float price = random.nextFloat() * 100;
			Service s = new Service(e, d, price);
			serviceRepository.save(s);
		}

		for (int i = 0; i < nbEvaluations; i++) {
			Evaluation evaluation = new Evaluation();
			evaluation.setText("Very good service, so cheap and so fast, incredible. I still can't believe my eyes how he masters his wand");
			evaluation.setPositive(random.nextBoolean());
			evaluation.setCustomer(customerRepository.findById(1l).get());
			evaluation.setExorcist(e);
			evaluationRepository.save(evaluation);
		}
	}

	private void addCustomer() throws Exception {
		User newCustomer = new User("customer", bCryptPasswordEncoder.encode("12345678"), "customer@email.com",
				RoleSeeder.customerRole);
		newCustomer = userRepository.save(newCustomer);

		Customer c = new Customer(newCustomer);
		customerRepository.save(c);
	}
}
