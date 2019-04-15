package ch.hearc.holygram.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ch.hearc.holygram.models.User;

/**
 * Documentation : https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 */
public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String string);
}