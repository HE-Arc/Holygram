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
	private EvaluationSeeder evaluationSeeder;

	@Autowired
	private ReligionSeeder religionSeeder;

	@Autowired
	private UserSeeder userSeeder;

	@Autowired
	private DemonSeeder demonsSeeder;

	@Autowired
	private RoleSeeder roleSeeder;

	@Autowired
	private ServiceSeeder serviceSeeder;

	@Autowired
	private PrivilegeSeeder privilegeSeeder;

	@PostConstruct
	public void seed() {
		privilegeSeeder.run();
		roleSeeder.run();
		cantonSeeder.run();
		religionSeeder.run();
		demonsSeeder.run();
		userSeeder.run();
		//evaluationSeeder.run();
		serviceSeeder.run();
	}
}
