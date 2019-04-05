package ch.hearc.holygram.seeders;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ch.hearc.holygram.accessors.PrivilegeRepository;
import ch.hearc.holygram.accessors.RoleRepository;
import ch.hearc.holygram.models.Privilege;
import ch.hearc.holygram.models.Role;

@Component
/**
 * Seeder for roles
 * @author Seg
 *
 */
public class RoleSeeder {

	@EventListener
	public void handleContextRefresh(ContextRefreshedEvent event) {
		this.run();
	}

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PrivilegeRepository privilegeRepository;

	public void run() {
		// Prepare Privileges
		Privilege profil_edit = privilegeRepository.findByName("PROFIL_EDIT");
		Privilege comment = privilegeRepository.findByName("COMMENT");
		Privilege show_details = privilegeRepository.findByName("SHOW_DETAILS");
		Privilege note = privilegeRepository.findByName("NOTE");
		Privilege account_delete = privilegeRepository.findByName("ACCOUNT_DELETE");
		Privilege account_edit = privilegeRepository.findByName("ACCOUNT_EDIT");
		
		Set<Privilege> customerPrivileges = new HashSet<Privilege>();
		customerPrivileges.add(comment);
		customerPrivileges.add(show_details);
		customerPrivileges.add(note);
		customerPrivileges.add(account_delete);
		customerPrivileges.add(account_edit);
		
		Set<Privilege> exorcistPrivileges = new HashSet<Privilege>();
		exorcistPrivileges.add(profil_edit);
		exorcistPrivileges.add(account_delete);
		exorcistPrivileges.add(account_edit);
		
		// Drop data
		roleRepository.deleteAll();

		// Insert data
		Role customerRole = new Role("CUSTOMER");
		customerRole.setPrivileges(customerPrivileges);
		roleRepository.save(customerRole);
		
		Role exorcistRole = new Role("EXORCIST");
		exorcistRole.setPrivileges(exorcistPrivileges);
		roleRepository.save(exorcistRole);
		
	}
}
