package com.sapient.userauthservice.service;

import java.util.Collection;
import java.util.Collections;

import com.sapient.userauthservice.exceptions.ResourceNotFoundException;
import com.sapient.userauthservice.model.Role;
import com.sapient.userauthservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.userauthservice.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("No user found with email: " + email));

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true,
				true, true, getAuthorities(user.getRole()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Role role) {
		return Collections.singletonList(new SimpleGrantedAuthority(role.toString()));
	}

}
