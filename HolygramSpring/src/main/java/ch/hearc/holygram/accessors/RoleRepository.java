package ch.hearc.holygram.accessors;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	Role findByName(String name);
}
