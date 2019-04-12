package ch.hearc.holygram.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.models.Privilege;
import ch.hearc.holygram.repositories.PrivilegeRepository;

@Component
/**
 * Seeder for profiles
 */
public class PrivilegeSeeder {

	@Autowired
	private PrivilegeRepository privilegeRepository;

	public void run() {

		// Drop data
		privilegeRepository.deleteAll();

		// Insert data
		privilegeRepository.save(new Privilege("PROFIL_EDIT"));
		privilegeRepository.save(new Privilege("COMMENT"));
		privilegeRepository.save(new Privilege("SHOW_DETAILS"));
		privilegeRepository.save(new Privilege("NOTE"));
		privilegeRepository.save(new Privilege("ACCOUNT_DELETE"));
		privilegeRepository.save(new Privilege("ACCOUNT_EDIT"));
	}
}