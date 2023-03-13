package com.grad.handywork.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grad.handywork.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{

}
