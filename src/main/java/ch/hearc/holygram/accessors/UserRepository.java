package ch.hearc.holygram.accessors;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.holygram.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
