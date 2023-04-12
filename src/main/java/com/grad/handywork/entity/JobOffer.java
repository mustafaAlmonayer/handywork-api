package com.grad.handywork.entity;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "job_offer")
public class JobOffer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "job_id")
	private Job job;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "user_id")
	private User user;
	
	@NotNull(message = "Amount Cannot Be Empty")
	@Column(name = "suggested_amount",nullable = false)
	private Integer suggestedAmount;
	
	@Column(name = "accepted", nullable = false)
	private Boolean accepted;
	
	@Column(name = "rejected", nullable = false)
	private Boolean rejected;

	public JobOffer() {
		super();
	}

	public JobOffer(Long id, Job job, User user, Integer suggestedAmount, Boolean accepted, Boolean rejected) {
		super();
		this.id = id;
		this.user = user;
		this.job = job;
		this.suggestedAmount = suggestedAmount;
		this.accepted = accepted;
		this.rejected = rejected;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
		if (job != null)
			job.getJobOffers().add(this);
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		if (user != null)
			user.getJobOffers().add(this);
	}

	public Integer getSuggestedAmount() {
		return suggestedAmount;
	}

	public void setSuggestedAmount(Integer suggestedAmount) {
		this.suggestedAmount = suggestedAmount;
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public Boolean getRejected() {
		return rejected;
	}

	public void setRejected(Boolean rejected) {
		this.rejected = rejected;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobOffer other = (JobOffer) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "JobOffer ["
				+ "id=" + id 
				+ ", job=" + job.getId() 
				+ ", user=" + user.getId() 
				+ ", suggestedAmount=" + suggestedAmount
				+ ", accepted=" + accepted 
				+ ", rejected=" + rejected 
				+ "]";
	}

}
