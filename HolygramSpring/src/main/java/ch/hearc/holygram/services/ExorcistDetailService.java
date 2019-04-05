package ch.hearc.holygram.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.hearc.holygram.accessors.ExorcistRepository;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.Role;
/*
@Service
public class ExorcistDetailService implements UserDetailsService {

	@Autowired
	private ExorcistRepository exorcistRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Exorcist exorcist = exorcistRepository.findByNameExorcist(username);
		if (exorcist == null)
			throw new UsernameNotFoundException(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : exorcist.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new User(exorcist.getName(), exorcist.getPassword(), grantedAuthorities);
	}
}*/
