package com.grad.handywork.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "job")
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "owner_id")
	private User owner;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "done_by_id")
	private User doneBy;

    @Column(name = "field")
    @NotNull(message = "\"Field\" Field cannot be empty")
	private String field;
    
    @Column(name = "description")
    @NotNull(message = "Description Field Cannot Be Empty")
    @Size(min = 15, message =  "Description Field Cannot Be Less Than 15")
	private String description;

    @Column(name = "publish_date")
    @Past
	private LocalDateTime publishDate;
    
    @Column(name = "update_date")
    @Past
	private LocalDateTime updateDate;

    @Column(name = "job_name")
    @NotNull(message = "Cannot Be Empty")
	private String jobName;
    
    @JoinColumn(name = "job_id")
    @ElementCollection
    @CollectionTable(name = "image_url")
    @Column(name = "url")
    @Size(max = 5, message = "Cannot Have More than 5 images")
	private List<String> imagesUrls;

    @Column(name = "is_done")
    @NotNull(message = "Cannot Be Empty")
	private boolean done;
    
    @Column(name="city")
    private String city;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId")
    @Size(max = 2)
    private List<JobReview> jobReviews;
   
	@Transient
    @Size(max = 5, message = "Cannot Have More than 5 images")
	private List<String> imagesFiles;

	public Job() {
		super();
	}

	public Job(
			Long id,
			User owner,
			User doneBy,
			String field,
			String description,
			LocalDateTime publishDate,
			LocalDateTime updateDate,
			String jobName,
			List<String> imagesUrls,
			String city,
			boolean isDone,
			List<JobReview> jobReview,
			List<String> imagesFiles
			) {
		super();
		this.id = id;
		this.owner = owner;
		this.doneBy = doneBy;
		this.field = field;
		this.description = description;
		this.publishDate = publishDate;
		this.updateDate = updateDate;
		this.jobName = jobName;
		this.imagesUrls = imagesUrls;
		this.city = city;
		this.done = isDone;
		this.jobReviews = jobReview;
		this.imagesFiles = imagesFiles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getDoneBy() {
		return doneBy;
	}

	public void setDoneBy(User doneBy) {
		this.doneBy = doneBy;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public List<String> getImagesUrls() {
		return imagesUrls;
	}

	public void setImagesUrls(List<String> imagesUrls) {
		this.imagesUrls = imagesUrls;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<JobReview> getJobReviews() {
		return jobReviews;
	}

	public void setJobReviews(List<JobReview> jobReviews) {
		this.jobReviews = jobReviews;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean isDone) {
		this.done = isDone;
	}

	public List<String> getImagesFiles() {
		return imagesFiles;
	}

	public void setImagesFiles(List<String> imagesFiles) {
		this.imagesFiles = imagesFiles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(doneBy.getId(), id, owner.getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		return Objects.equals(doneBy.getId(), other.doneBy.getId()) && Objects.equals(id, other.id)
				&& Objects.equals(owner.getId(), other.owner.getId());
	}

	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		jobReviews.forEach(jobReview -> {
			buffer.append(jobReview.getId());
			buffer.append(", ");
		});
		buffer.append("]");
		

		return "Job [id=" + id + ", owner=" + owner.getId() + ", doneBy=" + doneBy.getId() + ", field=" + field + ", description="
				+ description + " + , publishDate=" + publishDate + ", updateDate=" + updateDate
				+ ", jobName=" + jobName + ", imagesUrls=" + imagesUrls + ", isDone=" + done + ", city=" + city
				+ ", jobReviews=" + buffer + ", imagesFiles=" + imagesFiles + "]";
	}
	
}