package com.employee.management.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.management.models.User;
import com.employee.management.repo.JpaRepo;

@Service
public class UserServiceImpl implements UserDetailsService {

	/**
	 * JPA repository object
	 */
	@Autowired
	private JpaRepo jpaRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = jpaRepo.findByusername(username);
		return user.map(UserDetailsGroup::new)
				.orElseThrow(()->new UsernameNotFoundException("User:"+username+" Not Found!"));	
	}
}
