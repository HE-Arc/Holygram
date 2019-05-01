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

	private Role customerRole;
	private Role exorcistRole;

	public void run() {
		// Prepare Privileges
		Privilege profilEdit = privilegeRepository.findByName("PROFIL_EDIT");
		Privilege comment = privilegeRepository.findByName("COMMENT");
		Privilege showDetails = privilegeRepository.findByName("SHOW_DETAILS");
		Privilege note = privilegeRepository.findByName("NOTE");
		Privilege accountDelete = privilegeRepository.findByName("ACCOUNT_DELETE");
		Privilege accountEdit = privilegeRepository.findByName("ACCOUNT_EDIT");

		Set<Privilege> customerPrivileges = new HashSet<>();
		customerPrivileges.add(comment);
		customerPrivileges.add(showDetails);
		customerPrivileges.add(note);
		customerPrivileges.add(accountDelete);
		customerPrivileges.add(accountEdit);

		Set<Privilege> exorcistPrivileges = new HashSet<>();
		exorcistPrivileges.add(profilEdit);
		exorcistPrivileges.add(accountDelete);
		exorcistPrivileges.add(accountEdit);

		// Drop data
		roleRepository.deleteAll();

		// Insert data
		customerRole = new Role("ROLE_CUSTOMER");
		customerRole.setPrivileges(customerPrivileges);
		customerRole = roleRepository.save(customerRole);

		exorcistRole = new Role("ROLE_EXORCIST");
		exorcistRole.setPrivileges(exorcistPrivileges);
		exorcistRole = roleRepository.save(exorcistRole);
	}
	
	public Role getCustomerRole()
	{
		return customerRole;
	}
	
	public Role getExorcistRole()
	{
		return exorcistRole;
	}
}