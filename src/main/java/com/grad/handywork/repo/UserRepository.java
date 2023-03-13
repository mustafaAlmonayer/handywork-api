package com.grad.handywork.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grad.handywork.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	boolean existsByEmail(String email);
	boolean existsByPhoneNumber(String phoneNumber);
	boolean existsByUsername(String username);
	
}
