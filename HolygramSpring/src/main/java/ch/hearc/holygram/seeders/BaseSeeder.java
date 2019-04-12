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
	private CantonSeeder cs;

	@Autowired
	private ReligionSeeder rs;

	@Autowired
	private UserSeeder userSeeder;

	@Autowired
	private DemonSeeder ds;

	@Autowired
	private RoleSeeder roleSeeder;

	@Autowired
	private PrivilegeSeeder privilegeSeeder;

	@Autowired
	private ServiceSeeder serviceSeeder;

	@PostConstruct
	public void seed() {
		// Seed privileges
		privilegeSeeder.run();

		// Seed roles
		roleSeeder.run();

		// Seed cantons
		cs.run();

		// Seed religions
		rs.run();

		// Seed users
		userSeeder.run();

		// Seed demons
		ds.run();

		// Seed services
		serviceSeeder.run();
	}
}
