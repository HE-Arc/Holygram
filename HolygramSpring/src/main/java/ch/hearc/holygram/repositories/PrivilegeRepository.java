package ch.hearc.holygram.repositories;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.Privilege;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long>{
	Privilege findByName(String name);
}