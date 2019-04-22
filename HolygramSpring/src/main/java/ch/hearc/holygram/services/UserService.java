package ch.hearc.holygram.services;

import ch.hearc.holygram.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}