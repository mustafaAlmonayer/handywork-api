package com.grad.handywork.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grad.handywork.entity.JobReview;

@Repository
public interface JobReviewRepository extends JpaRepository<JobReview, Long>{

}
