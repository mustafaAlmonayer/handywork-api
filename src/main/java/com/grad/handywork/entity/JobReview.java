package com.grad.handywork.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import com.grad.handywork.enumtypes.JobReviewType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;

@Entity
@Table(name = "job-reviews")
public class JobReview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "job_id")
	private Long jobId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private JobReviewType type;
	
	@Column(name = "rating")
	private byte rating;
	
	@Column(name = "publish_date")
    @Past
	private LocalDateTime publishDate;
	
	@Column(name = "update_date")
    @Past
	private LocalDateTime updateDate;
	
	@Column(name = "review_text")
	private String reviewText;

	public JobReview() {
		super();
	}

	public JobReview(
			Long id,
			Long jobId,
			Long userId,
			JobReviewType type,
			byte rating,
			LocalDateTime publishDate,
			LocalDateTime updateDate,
			String reviewText
			) {
		super();
		this.id = id;
		this.jobId = jobId;
		this.userId = userId;
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

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
		return Objects.hash(id, jobId, type, userId);
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
		return Objects.equals(id, other.id) && Objects.equals(jobId, other.jobId) && type == other.type
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "JobReview [id=" + id + ", jobId=" + jobId + ", userId=" + userId + ", type=" + type + ", rating="
				+ rating + ", publishDate=" + publishDate + ", updateDate=" + updateDate + ", reviewText=" + reviewText
				+ "]";
	}
	
	
}
