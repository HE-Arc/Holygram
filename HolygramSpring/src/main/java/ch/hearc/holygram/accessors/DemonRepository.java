package ch.hearc.holygram.accessors;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.Demon;

/**
 * Documentation : https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * @author Seg
 *
 */
public interface DemonRepository extends CrudRepository<Demon, Long> {

}
