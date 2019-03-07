package ch.hearc.holygram.accessors;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.Service;

/**
 * Documentation : https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * @author Seg
 *
 */
public interface ServiceRepository extends CrudRepository<Service, Long> {

}
