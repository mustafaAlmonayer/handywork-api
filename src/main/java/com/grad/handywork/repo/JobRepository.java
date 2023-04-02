package com.grad.handywork.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grad.handywork.entity.Job;

@Repository("JobRepository")
public interface JobRepository extends JpaRepository<Job, Long>{
	
	Page<Job> findByFieldAndCity(String field, String city, PageRequest pageRequest);
	
	Page<Job> findByField(String field, PageRequest pageRequest);
	
	Page<Job> findByCity(String city, PageRequest pageRequest);

}
