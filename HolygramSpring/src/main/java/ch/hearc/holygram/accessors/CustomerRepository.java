package ch.hearc.holygram.accessors;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.Customer;

/**
 * Documentation :
 * https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
