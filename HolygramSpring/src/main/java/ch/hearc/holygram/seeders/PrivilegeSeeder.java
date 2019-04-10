package ch.hearc.holygram.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ch.hearc.holygram.repositories.PrivilegeRepository;
import ch.hearc.holygram.models.Privilege;

@Component
/**
 * Seeder for profiles
 * @author Seg
 *
 */
public class PrivilegeSeeder {

	@EventListener
	public void handleContextRefresh(ContextRefreshedEvent event) {
		this.run();
	}

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