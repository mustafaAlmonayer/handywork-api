package com.grad.handywork.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = " image_url")
public class ImageUrl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "job_id")
	private Long jobId;
	
	@Column(name = "url")
	private String url;

	public ImageUrl() {
		super();
	}

	public ImageUrl(Long id, Long jobId, String url) {
		super();
		this.id = id;
		this.jobId = jobId;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, jobId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImageUrl other = (ImageUrl) obj;
		return Objects.equals(id, other.id) && Objects.equals(jobId, other.jobId);
	}

	@Override
	public String toString() {
		return "ImageEntity [id=" + id + ", jobId=" + jobId + ", url=" + url + "]";
	}
	
}
