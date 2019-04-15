package ch.hearc.holygram.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.User;

/**
 * Documentation :
 * https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 */
public interface ExorcistRepository extends CrudRepository<Exorcist, Long> {
	public Exorcist findByUser(User user);
}
