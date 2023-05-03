package com.grad.handywork.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grad.handywork.entity.Job;
import com.grad.handywork.enumtypes.Cities;

@Repository("JobRepository")
public interface JobRepository extends JpaRepository<Job, Long>{
	
	List<Job> findAllByOwnerId(Long ownerId, Sort sort);
	
	Page<Job> findAllByDoneAndOwnerUsernameNot(boolean done, String username,PageRequest pageRequest);
	
	Page<Job> findByFieldIsLikeIgnoreCaseAndCityAndDoneAndOwnerUsernameNot(String field, Cities city, boolean done, String username, PageRequest pageRequest);
	
	Page<Job> findByFieldIsLikeIgnoreCaseAndDoneAndOwnerUsernameNot(String field, boolean done, String username, PageRequest pageRequest);
	
	Page<Job> findByCityAndDoneAndOwnerUsernameNot(Cities city, boolean done, String username, PageRequest pageRequest);
	
	@Query("SELECT j.field FROM Job j")
	Set<String> findAllFields();
	
}
