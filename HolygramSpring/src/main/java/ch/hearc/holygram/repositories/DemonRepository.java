package ch.hearc.holygram.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.Demon;
import ch.hearc.holygram.models.Religion;

/**
 * Documentation :
 * https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 */
public interface DemonRepository extends CrudRepository<Demon, Long> {
	//List<Demon> findByNameIgnoreCase(String demonName);
	//List<Demon> findByReligion(Religion religion);
}
