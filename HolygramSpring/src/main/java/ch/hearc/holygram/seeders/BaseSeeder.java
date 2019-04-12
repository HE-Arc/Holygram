package ch.hearc.holygram.seeders;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
/**
 * Seeder for cantons
 */
public class BaseSeeder {

	@Autowired
	private CantonSeeder cantonSeeder;

	@Autowired
	private ReligionSeeder religionSeeder;

	@Autowired
	private UserSeeder userSeeder;

	@Autowired
	private DemonSeeder demonsSeeder;

	@Autowired
	private RoleSeeder roleSeeder;

	@Autowired
	private PrivilegeSeeder privilegeSeeder;

	@PostConstruct
	public void seed() {
		// Seed privileges
		privilegeSeeder.run();

		// Seed roles
		roleSeeder.run();

		// Seed cantons
		cantonSeeder.run();

		// Seed religions
		religionSeeder.run();

		// Seed demons
		demonsSeeder.run();

		// Seed users
		userSeeder.run();
	}
}
