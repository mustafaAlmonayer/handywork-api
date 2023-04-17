package com.grad.handywork.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grad.handywork.entity.Job;

@Repository("JobRepository")
public interface JobRepository extends JpaRepository<Job, Long>{
	
	List<Job> findAllByOwnerId(Long ownerId, Sort sort);
	
	Page<Job> findAllByDoneAndOwnerUsernameNot(boolean done, String username,PageRequest pageRequest);
	
	Page<Job> findByFieldIsLikeIgnoreCaseAndCityIsLikeIgnoreCaseAndDoneAndOwnerUsernameNot(String field, String username, String city, boolean done, PageRequest pageRequest);
	
	Page<Job> findByFieldIsLikeIgnoreCaseAndDoneAndOwnerUsernameNot(String field, boolean done, String username, PageRequest pageRequest);
	
	Page<Job> findByCityIsLikeIgnoreCaseAndDoneAndOwnerUsernameNot(String city, boolean done, String username, PageRequest pageRequest);

}
