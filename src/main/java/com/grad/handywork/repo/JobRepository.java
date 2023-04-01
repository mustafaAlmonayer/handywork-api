package com.grad.handywork.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grad.handywork.entity.Job;

@Repository("JobRepository")
public interface JobRepository extends JpaRepository<Job, Long>{
	
	List<Job> findByFieldAndJobName(String field, String name);
	
	List<Job> findByField(String field);
	
	List<Job> findByJobName(String name);

}
