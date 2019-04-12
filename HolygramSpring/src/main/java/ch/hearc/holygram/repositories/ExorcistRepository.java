package ch.hearc.holygram.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.Exorcist;

/**
 * Documentation : https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 */
public interface ExorcistRepository extends CrudRepository<Exorcist, Long> {
	List<Exorcist> findByName(String Name);
}
