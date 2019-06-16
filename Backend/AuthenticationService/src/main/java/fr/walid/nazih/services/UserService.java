package fr.walid.nazih.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.walid.nazih.models.AppUser;
import fr.walid.nazih.repositories.AppUserRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private AppUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AppUser user = userRepository.findByUsername(username);
		
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		
		user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRole())));
		
		return new User(user.getUsername(), user.getPassword(), authorities);
	}

}
