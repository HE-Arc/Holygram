package ch.hearc.holygram.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userService.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userService.findByUsername(username);
    }
}