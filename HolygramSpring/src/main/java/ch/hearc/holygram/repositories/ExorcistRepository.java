package ch.hearc.holygram.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.Exorcist;

/**
 * Documentation :
 * https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 */
public interface ExorcistRepository extends CrudRepository<Exorcist, Long> {
	@Query("SELECT e FROM Exorcist e WHERE e.id IN (SELECT s.fk_exorcist FROM Service s WHERE s.fk_demon = ?1)")
	List<Exorcist> findByDemonID(Long demon_id);
}
