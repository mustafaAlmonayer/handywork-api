package com.grad.handywork.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class JobDto {

	private Long id;

	private String owner;

	private String doneBy;

	@Size(min = 3, max = 36, message = "\"Field\" Field Cannot Be Less Than 3 Or bigger Than 36")
	@NotNull(message = "\"Field\" Field cannot be empty")
	private String field;

	@NotNull(message = "Description Field Cannot Be Empty")
	@Size(min = 15, max = 512, message = "Description Field Cannot Be Less Than 15 Or bigger Than 512")
	private String description;

	private LocalDateTime publishDate;

	@JsonInclude(value = Include.ALWAYS)
	private LocalDateTime updateDate;

	@Size(min = 3, max = 36, message = "Tile Field Cannot Be Less Than 3 Or bigger Than 36")
	@NotNull(message = "Cannot Be Empty")
	private String jobName;

	private List<String> imagesUrls;

	private Boolean done;

	@NotNull(message = "City Field Cannot be empty")
	private String city;

	@Size(max = 5, message = "Cannot Have More than 5 images")
	private List<String> imagesFiles;

	public JobDto(Long id, String owner, String doneBy, @Size(min = 3, max = 36, message = "\"Field\" Field Cannot Be Less Than 3 Or bigger Than 36") @NotNull(message = "\"Field\" Field cannot be empty") String field, @NotNull(message = "Description Field Cannot Be Empty") @Size(min = 15, max = 512, message = "Description Field Cannot Be Less Than 15 Or bigger Than 512") String description, LocalDateTime publishDate, LocalDateTime updateDate, @Size(min = 3, max = 36, message = "Tile Field Cannot Be Less Than 3 Or bigger Than 36") @NotNull(message = "Cannot Be Empty") String jobName, List<String> imagesUrls, Boolean done, @NotNull(message = "City Field Cannot be empty") String city, @Size(max = 5, message = "Cannot Have More than 5 images") List<String> imagesFiles) {
		this.id = id;
		this.owner = owner;
		this.doneBy = doneBy;
		this.field = field;
		this.description = description;
		this.publishDate = publishDate;
		this.updateDate = updateDate;
		this.jobName = jobName;
		this.imagesUrls = imagesUrls;
		this.done = done;
		this.city = city;
		this.imagesFiles = imagesFiles;
	}

	public JobDto() {
	}

	public static JobDtoBuilder builder() {
		return new JobDtoBuilder();
	}

	public Long getId() {
		return this.id;
	}

	public String getOwner() {
		return this.owner;
	}

	public String getDoneBy() {
		return this.doneBy;
	}

	public @Size(min = 3, max = 36, message = "\"Field\" Field Cannot Be Less Than 3 Or bigger Than 36") @NotNull(message = "\"Field\" Field cannot be empty") String getField() {
		return this.field;
	}

	public @NotNull(message = "Description Field Cannot Be Empty") @Size(min = 15, max = 512, message = "Description Field Cannot Be Less Than 15 Or bigger Than 512") String getDescription() {
		return this.description;
	}

	public LocalDateTime getPublishDate() {
		return this.publishDate;
	}

	public LocalDateTime getUpdateDate() {
		return this.updateDate;
	}

	public @Size(min = 3, max = 36, message = "Tile Field Cannot Be Less Than 3 Or bigger Than 36") @NotNull(message = "Cannot Be Empty") String getJobName() {
		return this.jobName;
	}

	public List<String> getImagesUrls() {
		return this.imagesUrls;
	}

	public Boolean getDone() {
		return this.done;
	}

	public @NotNull(message = "City Field Cannot be empty") String getCity() {
		return this.city;
	}

	public @Size(max = 5, message = "Cannot Have More than 5 images") List<String> getImagesFiles() {
		return this.imagesFiles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setDoneBy(String doneBy) {
		this.doneBy = doneBy;
	}

	public void setField(@Size(min = 3, max = 36, message = "\"Field\" Field Cannot Be Less Than 3 Or bigger Than 36") @NotNull(message = "\"Field\" Field cannot be empty") String field) {
		this.field = field;
	}

	public void setDescription(@NotNull(message = "Description Field Cannot Be Empty") @Size(min = 15, max = 512, message = "Description Field Cannot Be Less Than 15 Or bigger Than 512") String description) {
		this.description = description;
	}

	public void setPublishDate(LocalDateTime publishDate) {
		this.publishDate = publishDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public void setJobName(@Size(min = 3, max = 36, message = "Tile Field Cannot Be Less Than 3 Or bigger Than 36") @NotNull(message = "Cannot Be Empty") String jobName) {
		this.jobName = jobName;
	}

	public void setImagesUrls(List<String> imagesUrls) {
		this.imagesUrls = imagesUrls;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public void setCity(@NotNull(message = "City Field Cannot be empty") String city) {
		this.city = city;
	}

	public void setImagesFiles(@Size(max = 5, message = "Cannot Have More than 5 images") List<String> imagesFiles) {
		this.imagesFiles = imagesFiles;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof JobDto)) return false;
		final JobDto other = (JobDto) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$id = this.getId();
		final Object other$id = other.getId();
		if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
		final Object this$owner = this.getOwner();
		final Object other$owner = other.getOwner();
		if (this$owner == null ? other$owner != null : !this$owner.equals(other$owner)) return false;
		final Object this$doneBy = this.getDoneBy();
		final Object other$doneBy = other.getDoneBy();
		if (this$doneBy == null ? other$doneBy != null : !this$doneBy.equals(other$doneBy)) return false;
		final Object this$field = this.getField();
		final Object other$field = other.getField();
		if (this$field == null ? other$field != null : !this$field.equals(other$field)) return false;
		final Object this$description = this.getDescription();
		final Object other$description = other.getDescription();
		if (this$description == null ? other$description != null : !this$description.equals(other$description))
			return false;
		final Object this$publishDate = this.getPublishDate();
		final Object other$publishDate = other.getPublishDate();
		if (this$publishDate == null ? other$publishDate != null : !this$publishDate.equals(other$publishDate))
			return false;
		final Object this$updateDate = this.getUpdateDate();
		final Object other$updateDate = other.getUpdateDate();
		if (this$updateDate == null ? other$updateDate != null : !this$updateDate.equals(other$updateDate))
			return false;
		final Object this$jobName = this.getJobName();
		final Object other$jobName = other.getJobName();
		if (this$jobName == null ? other$jobName != null : !this$jobName.equals(other$jobName)) return false;
		final Object this$imagesUrls = this.getImagesUrls();
		final Object other$imagesUrls = other.getImagesUrls();
		if (this$imagesUrls == null ? other$imagesUrls != null : !this$imagesUrls.equals(other$imagesUrls))
			return false;
		final Object this$done = this.getDone();
		final Object other$done = other.getDone();
		if (this$done == null ? other$done != null : !this$done.equals(other$done)) return false;
		final Object this$city = this.getCity();
		final Object other$city = other.getCity();
		if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
		final Object this$imagesFiles = this.getImagesFiles();
		final Object other$imagesFiles = other.getImagesFiles();
		if (this$imagesFiles == null ? other$imagesFiles != null : !this$imagesFiles.equals(other$imagesFiles))
			return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof JobDto;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $id = this.getId();
		result = result * PRIME + ($id == null ? 43 : $id.hashCode());
		final Object $owner = this.getOwner();
		result = result * PRIME + ($owner == null ? 43 : $owner.hashCode());
		final Object $doneBy = this.getDoneBy();
		result = result * PRIME + ($doneBy == null ? 43 : $doneBy.hashCode());
		final Object $field = this.getField();
		result = result * PRIME + ($field == null ? 43 : $field.hashCode());
		final Object $description = this.getDescription();
		result = result * PRIME + ($description == null ? 43 : $description.hashCode());
		final Object $publishDate = this.getPublishDate();
		result = result * PRIME + ($publishDate == null ? 43 : $publishDate.hashCode());
		final Object $updateDate = this.getUpdateDate();
		result = result * PRIME + ($updateDate == null ? 43 : $updateDate.hashCode());
		final Object $jobName = this.getJobName();
		result = result * PRIME + ($jobName == null ? 43 : $jobName.hashCode());
		final Object $imagesUrls = this.getImagesUrls();
		result = result * PRIME + ($imagesUrls == null ? 43 : $imagesUrls.hashCode());
		final Object $done = this.getDone();
		result = result * PRIME + ($done == null ? 43 : $done.hashCode());
		final Object $city = this.getCity();
		result = result * PRIME + ($city == null ? 43 : $city.hashCode());
		final Object $imagesFiles = this.getImagesFiles();
		result = result * PRIME + ($imagesFiles == null ? 43 : $imagesFiles.hashCode());
		return result;
	}

	public String toString() {
		return "JobDto(id=" + this.getId() + ", owner=" + this.getOwner() + ", doneBy=" + this.getDoneBy() + ", field=" + this.getField() + ", description=" + this.getDescription() + ", publishDate=" + this.getPublishDate() + ", updateDate=" + this.getUpdateDate() + ", jobName=" + this.getJobName() + ", imagesUrls=" + this.getImagesUrls() + ", done=" + this.getDone() + ", city=" + this.getCity() + ", imagesFiles=" + this.getImagesFiles() + ")";
	}

	public static class JobDtoBuilder {
		private Long id;
		private String owner;
		private String doneBy;
		private @Size(min = 3, max = 36, message = "\"Field\" Field Cannot Be Less Than 3 Or bigger Than 36")
		@NotNull(message = "\"Field\" Field cannot be empty") String field;
		private @NotNull(message = "Description Field Cannot Be Empty")
		@Size(min = 15, max = 512, message = "Description Field Cannot Be Less Than 15 Or bigger Than 512") String description;
		private LocalDateTime publishDate;
		private LocalDateTime updateDate;
		private @Size(min = 3, max = 36, message = "Tile Field Cannot Be Less Than 3 Or bigger Than 36")
		@NotNull(message = "Cannot Be Empty") String jobName;
		private List<String> imagesUrls;
		private Boolean done;
		private @NotNull(message = "City Field Cannot be empty") String city;
		private @Size(max = 5, message = "Cannot Have More than 5 images") List<String> imagesFiles;

		JobDtoBuilder() {
		}

		public JobDtoBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public JobDtoBuilder owner(String owner) {
			this.owner = owner;
			return this;
		}

		public JobDtoBuilder doneBy(String doneBy) {
			this.doneBy = doneBy;
			return this;
		}

		public JobDtoBuilder field(@Size(min = 3, max = 36, message = "\"Field\" Field Cannot Be Less Than 3 Or bigger Than 36") @NotNull(message = "\"Field\" Field cannot be empty") String field) {
			this.field = field;
			return this;
		}

		public JobDtoBuilder description(@NotNull(message = "Description Field Cannot Be Empty") @Size(min = 15, max = 512, message = "Description Field Cannot Be Less Than 15 Or bigger Than 512") String description) {
			this.description = description;
			return this;
		}

		public JobDtoBuilder publishDate(LocalDateTime publishDate) {
			this.publishDate = publishDate;
			return this;
		}

		public JobDtoBuilder updateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public JobDtoBuilder jobName(@Size(min = 3, max = 36, message = "Tile Field Cannot Be Less Than 3 Or bigger Than 36") @NotNull(message = "Cannot Be Empty") String jobName) {
			this.jobName = jobName;
			return this;
		}

		public JobDtoBuilder imagesUrls(List<String> imagesUrls) {
			this.imagesUrls = imagesUrls;
			return this;
		}

		public JobDtoBuilder done(Boolean done) {
			this.done = done;
			return this;
		}

		public JobDtoBuilder city(@NotNull(message = "City Field Cannot be empty") String city) {
			this.city = city;
			return this;
		}

		public JobDtoBuilder imagesFiles(@Size(max = 5, message = "Cannot Have More than 5 images") List<String> imagesFiles) {
			this.imagesFiles = imagesFiles;
			return this;
		}

		public JobDto build() {
			return new JobDto(this.id, this.owner, this.doneBy, this.field, this.description, this.publishDate, this.updateDate, this.jobName, this.imagesUrls, this.done, this.city, this.imagesFiles);
		}

		public String toString() {
			return "JobDto.JobDtoBuilder(id=" + this.id + ", owner=" + this.owner + ", doneBy=" + this.doneBy + ", field=" + this.field + ", description=" + this.description + ", publishDate=" + this.publishDate + ", updateDate=" + this.updateDate + ", jobName=" + this.jobName + ", imagesUrls=" + this.imagesUrls + ", done=" + this.done + ", city=" + this.city + ", imagesFiles=" + this.imagesFiles + ")";
		}
	}
}
