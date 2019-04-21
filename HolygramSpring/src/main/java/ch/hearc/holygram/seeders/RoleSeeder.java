package ch.hearc.holygram.seeders;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ch.hearc.holygram.models.Privilege;
import ch.hearc.holygram.models.Role;
import ch.hearc.holygram.repositories.PrivilegeRepository;
import ch.hearc.holygram.repositories.RoleRepository;

@Component
/**
 * Seeder for roles
 */
public class RoleSeeder {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PrivilegeRepository privilegeRepository;

	public static Role customerRole;
	public static Role exorcistRole;

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
		Role customerRole = new Role("ROLE_CUSTOMER");
		customerRole.setPrivileges(customerPrivileges);
		roleRepository.save(customerRole);

		Role exorcistRole = new Role("ROLE_EXORCIST");
		exorcistRole.setPrivileges(exorcistPrivileges);
		roleRepository.save(exorcistRole);

		RoleSeeder.customerRole = customerRole;
		RoleSeeder.exorcistRole = exorcistRole;
	}
}