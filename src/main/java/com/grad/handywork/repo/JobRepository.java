package com.grad.handywork.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grad.handywork.entity.Job;

@Repository("JobRepository")
public interface JobRepository extends JpaRepository<Job, Long>{
	
	Page<Job> findAllByDone(boolean done, PageRequest pageRequest);
	
	Page<Job> findByFieldIsLikeIgnoreCaseAndCityIsLikeIgnoreCaseAndDone(String field, String city, boolean done, PageRequest pageRequest);
	
	Page<Job> findByFieldIsLikeIgnoreCaseAndDone(String field, boolean done, PageRequest pageRequest);
	
	Page<Job> findByCityIsLikeIgnoreCaseAndDone(String city, boolean done, PageRequest pageRequest);

}
