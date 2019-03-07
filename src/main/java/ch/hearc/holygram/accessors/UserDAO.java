package ch.hearc.holygram.accessors;

import java.util.List;

import javax.validation.Valid;

import ch.hearc.holygram.models.User;

public interface UserDAO {

	List<User> findAll();

	void save(@Valid User utilisateur);

}
