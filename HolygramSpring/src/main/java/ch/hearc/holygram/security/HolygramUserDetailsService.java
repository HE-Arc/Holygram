package ch.hearc.holygram.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.UserRepository;

@Service
public class HolygramUserDetailsService implements UserDetailsService {

	@Autowired
	private WebApplicationContext applicationContext;
	@Autowired
	private UserRepository userRepository;

	public HolygramUserDetailsService() {
        super();
    }

    @PostConstruct
    public void completeSetup() {
        //userRepository = applicationContext.getBean(UserRepository.class);
    }
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException(username);
		
		return new HolygramUserDetails(user);
	}
}
