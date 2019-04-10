package ch.hearc.holygram.repositories;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.Canton;

/**
 * Documentation :
 * https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 */
public interface CantonRepository extends CrudRepository<Canton, Long> {

}
