package ch.hearc.holygram.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.Demon;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.Service;

/**
 * Documentation :
 * https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 */
public interface ServiceRepository extends CrudRepository<Service, Long> {
	public List<Exorcist> findAllExorcistByDemon(Demon demon);

	public List<Demon> findAllDemonByExorcist(Exorcist exorcist);
}
