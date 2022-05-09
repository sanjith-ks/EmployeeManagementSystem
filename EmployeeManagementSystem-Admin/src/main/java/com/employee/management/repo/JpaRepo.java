package com.employee.management.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.management.models.User;

@Repository
public interface JpaRepo extends JpaRepository<User, String> {
	
	/**
	 * method to find user name for security services
	 * @param String
	 * @return object
	 */
	Optional<User> findByusername(String s);
}
