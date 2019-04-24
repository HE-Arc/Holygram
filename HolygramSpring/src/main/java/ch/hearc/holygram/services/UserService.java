package ch.hearc.holygram.services;

import ch.hearc.holygram.models.User;

public interface UserService {
	User save(User user);

    User findByUsername(String username);
}