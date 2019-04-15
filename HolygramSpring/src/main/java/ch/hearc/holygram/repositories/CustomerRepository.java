package ch.hearc.holygram.repositories;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.Customer;
import ch.hearc.holygram.models.User;

/**
 * Documentation :
 * https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	public Customer findByUser(User user);
}
