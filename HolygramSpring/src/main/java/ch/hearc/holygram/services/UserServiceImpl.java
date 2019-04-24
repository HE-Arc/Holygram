package ch.hearc.holygram.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user = userRepository.save(user);
        
        return user;
    }

    @Override
    public User findByUsername(String username) {
    	Optional<User> user = userRepository.findByUsername(username);
    	
        return user.isPresent() ? user.get() : null;
    }
}