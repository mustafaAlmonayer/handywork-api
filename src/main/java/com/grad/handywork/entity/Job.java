package com.grad.handywork.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "job")
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	private User owner;
	
	@Column(name = "done_by_id")
	private Long doneBy;

    @Column(name = "field")
    @NotNull(message = "\"Field\" Field cannot be empty")
	private String field;
    
    @Column(name = "description")
    @NotNull(message = "Description Field Cannot Be Empty")
    @Size(min = 15, message =  "Description Field Cannot Be Less Than 15")
	private String description;

    @Column(name = "pay", columnDefinition = "DECIMAL(6,2)")
    @Min(value = 0, message = "Price Field Cannot Be Less Than 0")
    @Max(value = 999999, message = "Price Field Cannot Be Higher Than 999999")
    @Digits(integer = 6, fraction = 2, message = "Price Field Max Number Of Digits Is 6, Fraction Is 2")
    @NotNull(message = "Price Field Cannot Be Empty")
	private float pay;

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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Size(max = 5, message = "Cannot Have More than 5 images")
	private List<ImageUrl> imagesUrls;

    @Column(name = "is_done")
    @NotNull(message = "Cannot Be Empty")
	private boolean isDone;
    
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
			Long doneBy,
			String field,
			String description,
			float price,
			LocalDateTime publishDate,
			LocalDateTime updateDate,
			String jobName,
			List<ImageUrl> imagesUrls,
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
		this.pay = price;
		this.publishDate = publishDate;
		this.updateDate = updateDate;
		this.jobName = jobName;
		this.imagesUrls = imagesUrls;
		this.city = city;
		this.isDone = isDone;
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

	public Long getDoneBy() {
		return doneBy;
	}

	public void setDoneBy(Long doneBy) {
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

	public List<ImageUrl> getImagesUrls() {
		return imagesUrls;
	}

	public void setImagesUrls(List<ImageUrl> imagesUrls) {
		this.imagesUrls = imagesUrls;
	}
	
	public float getPay() {
		return pay;
	}

	public void setPay(float pay) {
		this.pay = pay;
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
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public List<String> getImagesFiles() {
		return imagesFiles;
	}

	public void setImagesFiles(List<String> imagesFiles) {
		this.imagesFiles = imagesFiles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(doneBy, id, owner.getId(), pay);
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
		return Objects.equals(doneBy, other.doneBy) && Objects.equals(id, other.id)
				&& Objects.equals(owner.getId(), other.owner.getId())
				&& Double.doubleToLongBits(pay) == Double.doubleToLongBits(other.pay);
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
		

		return "Job [id=" + id + ", owner=" + owner.getId() + ", doneBy=" + doneBy + ", field=" + field + ", description="
				+ description + ", pay=" + pay + ", publishDate=" + publishDate + ", updateDate=" + updateDate
				+ ", jobName=" + jobName + ", imagesUrls=" + imagesUrls + ", isDone=" + isDone + ", city=" + city
				+ ", jobReviews=" + buffer + ", imagesFiles=" + imagesFiles + "]";
	}
	
}