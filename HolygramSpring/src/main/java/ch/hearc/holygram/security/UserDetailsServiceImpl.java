package ch.hearc.holygram.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.UserRepository;
import ch.hearc.holygram.services.UserServiceImpl;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userService.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        return new HolygramUserDetails(user);
    }
}