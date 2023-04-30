package com.grad.handywork.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import com.grad.handywork.enumtypes.JobReviewType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "job_review")
public class JobReview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "job_id")
	private Job job;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "by_user_id")
	private User byUser;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "on_user_id")
	private User onUser;
	
	@Column(name = "type", columnDefinition = "ENUM('JOB_REVIEW', 'USER_REVIEW')")
	@Enumerated(EnumType.STRING)
	private JobReviewType type;
	
	@Column(name = "rating")
	@Min(value = 1, message = "Ratting Cannot Be Less Than 1")
	@Max(value = 5, message = "Ratting Cannot Be More Than 5")
	@NotNull(message = "Ratting Cannot Be Empty")
	private byte rating;
	
	@Column(name = "publish_date")
    @Past
	private LocalDateTime publishDate;
	
	@Column(name = "update_date")
    @Past
	private LocalDateTime updateDate;
	
	@Column(name = "review_text")
	@NotNull(message = "Review Text Cannot Be Empty")
	@Size(min = 15, max = 512, message = "Description Field Cannot Be Less Than 15 Or bigger Than 512")
	private String reviewText;

	public JobReview() {
		super();
	}

	public JobReview(Long id, Job job, User user, JobReviewType type, byte rating, LocalDateTime publishDate,
			LocalDateTime updateDate, String reviewText) {
		super();
		this.id = id;
		this.job = job;
		this.byUser = user;
		this.type = type;
		this.rating = rating;
		this.publishDate = publishDate;
		this.updateDate = updateDate;
		this.reviewText = reviewText;
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
			job.getJobReviews().add(this);
	}

	public User getByUser() {
		return byUser;
	}

	public void setByUser(User byUser) {
		this.byUser = byUser;
		if (byUser != null)
			byUser.getOwnedJobReviews().add(this);
	}

	public User getOnUser() {
		return onUser;
	}

	public void setOnUser(User onUser) {
		this.onUser = onUser;
		onUser.getOnJobReviews().add(this);
	}

	public JobReviewType getType() {
		return type;
	}

	public void setType(JobReviewType type) {
		this.type = type;
	}

	public byte getRating() {
		return rating;
	}
	
	public void setRating(byte rating) {
		this.rating = rating;
	}

	public LocalDateTime getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDateTime publishDate) {
		this.publishDate = publishDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
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
		JobReview other = (JobReview) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "JobReview ["
				+ "id=" + id 
				+ ", job=" + job.getId() 
				+ ", byUser=" + byUser.getId()
				+ ", onUser=" + onUser.getId() 
				+ ", type=" + type 
				+ ", rating=" + rating
				+ ", publishDate=" + publishDate 
				+ ", updateDate=" + updateDate 
				+ ", reviewText=" + reviewText 
				+ "]";
	}
	
}
