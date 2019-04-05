package ch.hearc.holygram.accessors;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.Privilege;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long>{
	Privilege findByName(String name);
}
