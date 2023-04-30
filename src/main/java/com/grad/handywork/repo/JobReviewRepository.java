package com.grad.handywork.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grad.handywork.entity.JobReview;
import com.grad.handywork.enumtypes.JobReviewType;

@Repository
public interface JobReviewRepository extends JpaRepository<JobReview, Long>{

	boolean existsByJobIdAndType(Long id, JobReviewType type);
	
}
