package com.grad.handywork.dto;

import com.grad.handywork.enumtypes.JobReviewType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class JobReviewDto {

	private Long id;

	private Long jobId;

	private String jobName;

	private String byUserUsername;

	private String byUserUsernameImageUrl;

	private String onUserUsername;

	private String onUserUsernameImageUrl;

	private JobReviewType type;

	@Min(value = 1, message = "Ratting Cannot Be Less Than 1")
	@Max(value = 5, message = "Ratting Cannot Be More Than 5")
	@NotNull(message = "Ratting Cannot Be Empty")
	private byte rating;

	private LocalDateTime publishDate;

	private LocalDateTime updateDate;

	@NotNull(message = "Review Text Cannot Be Empty")
	@Size(min = 15, max = 512, message = "Description Field Cannot Be Less Than 15 Or bigger Than 512")
	private String reviewText;

	public JobReviewDto(Long id, Long jobId, String jobName, String byUserUsername, String byUserUsernameImageUrl, String onUserUsername, String onUserUsernameImageUrl, JobReviewType type, @Min(value = 1, message = "Ratting Cannot Be Less Than 1") @Max(value = 5, message = "Ratting Cannot Be More Than 5") @NotNull(message = "Ratting Cannot Be Empty") byte rating, LocalDateTime publishDate, LocalDateTime updateDate, @NotNull(message = "Review Text Cannot Be Empty") @Size(min = 15, max = 512, message = "Description Field Cannot Be Less Than 15 Or bigger Than 512") String reviewText) {
		this.id = id;
		this.jobId = jobId;
		this.jobName = jobName;
		this.byUserUsername = byUserUsername;
		this.byUserUsernameImageUrl = byUserUsernameImageUrl;
		this.onUserUsername = onUserUsername;
		this.onUserUsernameImageUrl = onUserUsernameImageUrl;
		this.type = type;
		this.rating = rating;
		this.publishDate = publishDate;
		this.updateDate = updateDate;
		this.reviewText = reviewText;
	}

	public JobReviewDto() {
	}

	public static JobReviewDtoBuilder builder() {
		return new JobReviewDtoBuilder();
	}

	public Long getId() {
		return this.id;
	}

	public Long getJobId() {
		return this.jobId;
	}

	public String getJobName() {
		return this.jobName;
	}

	public String getByUserUsername() {
		return this.byUserUsername;
	}

	public String getByUserUsernameImageUrl() {
		return this.byUserUsernameImageUrl;
	}

	public String getOnUserUsername() {
		return this.onUserUsername;
	}

	public String getOnUserUsernameImageUrl() {
		return this.onUserUsernameImageUrl;
	}

	public JobReviewType getType() {
		return this.type;
	}

	public @Min(value = 1, message = "Ratting Cannot Be Less Than 1") @Max(value = 5, message = "Ratting Cannot Be More Than 5") @NotNull(message = "Ratting Cannot Be Empty") byte getRating() {
		return this.rating;
	}

	public LocalDateTime getPublishDate() {
		return this.publishDate;
	}

	public LocalDateTime getUpdateDate() {
		return this.updateDate;
	}

	public @NotNull(message = "Review Text Cannot Be Empty") @Size(min = 15, max = 512, message = "Description Field Cannot Be Less Than 15 Or bigger Than 512") String getReviewText() {
		return this.reviewText;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public void setByUserUsername(String byUserUsername) {
		this.byUserUsername = byUserUsername;
	}

	public void setByUserUsernameImageUrl(String byUserUsernameImageUrl) {
		this.byUserUsernameImageUrl = byUserUsernameImageUrl;
	}

	public void setOnUserUsername(String onUserUsername) {
		this.onUserUsername = onUserUsername;
	}

	public void setOnUserUsernameImageUrl(String onUserUsernameImageUrl) {
		this.onUserUsernameImageUrl = onUserUsernameImageUrl;
	}

	public void setType(JobReviewType type) {
		this.type = type;
	}

	public void setRating(@Min(value = 1, message = "Ratting Cannot Be Less Than 1") @Max(value = 5, message = "Ratting Cannot Be More Than 5") @NotNull(message = "Ratting Cannot Be Empty") byte rating) {
		this.rating = rating;
	}

	public void setPublishDate(LocalDateTime publishDate) {
		this.publishDate = publishDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public void setReviewText(@NotNull(message = "Review Text Cannot Be Empty") @Size(min = 15, max = 512, message = "Description Field Cannot Be Less Than 15 Or bigger Than 512") String reviewText) {
		this.reviewText = reviewText;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof JobReviewDto)) return false;
		final JobReviewDto other = (JobReviewDto) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$id = this.getId();
		final Object other$id = other.getId();
		if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
		final Object this$jobId = this.getJobId();
		final Object other$jobId = other.getJobId();
		if (this$jobId == null ? other$jobId != null : !this$jobId.equals(other$jobId)) return false;
		final Object this$jobName = this.getJobName();
		final Object other$jobName = other.getJobName();
		if (this$jobName == null ? other$jobName != null : !this$jobName.equals(other$jobName)) return false;
		final Object this$byUserUsername = this.getByUserUsername();
		final Object other$byUserUsername = other.getByUserUsername();
		if (this$byUserUsername == null ? other$byUserUsername != null : !this$byUserUsername.equals(other$byUserUsername))
			return false;
		final Object this$byUserUsernameImageUrl = this.getByUserUsernameImageUrl();
		final Object other$byUserUsernameImageUrl = other.getByUserUsernameImageUrl();
		if (this$byUserUsernameImageUrl == null ? other$byUserUsernameImageUrl != null : !this$byUserUsernameImageUrl.equals(other$byUserUsernameImageUrl))
			return false;
		final Object this$onUserUsername = this.getOnUserUsername();
		final Object other$onUserUsername = other.getOnUserUsername();
		if (this$onUserUsername == null ? other$onUserUsername != null : !this$onUserUsername.equals(other$onUserUsername))
			return false;
		final Object this$onUserUsernameImageUrl = this.getOnUserUsernameImageUrl();
		final Object other$onUserUsernameImageUrl = other.getOnUserUsernameImageUrl();
		if (this$onUserUsernameImageUrl == null ? other$onUserUsernameImageUrl != null : !this$onUserUsernameImageUrl.equals(other$onUserUsernameImageUrl))
			return false;
		final Object this$type = this.getType();
		final Object other$type = other.getType();
		if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
		if (this.getRating() != other.getRating()) return false;
		final Object this$publishDate = this.getPublishDate();
		final Object other$publishDate = other.getPublishDate();
		if (this$publishDate == null ? other$publishDate != null : !this$publishDate.equals(other$publishDate))
			return false;
		final Object this$updateDate = this.getUpdateDate();
		final Object other$updateDate = other.getUpdateDate();
		if (this$updateDate == null ? other$updateDate != null : !this$updateDate.equals(other$updateDate))
			return false;
		final Object this$reviewText = this.getReviewText();
		final Object other$reviewText = other.getReviewText();
		if (this$reviewText == null ? other$reviewText != null : !this$reviewText.equals(other$reviewText))
			return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof JobReviewDto;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $id = this.getId();
		result = result * PRIME + ($id == null ? 43 : $id.hashCode());
		final Object $jobId = this.getJobId();
		result = result * PRIME + ($jobId == null ? 43 : $jobId.hashCode());
		final Object $jobName = this.getJobName();
		result = result * PRIME + ($jobName == null ? 43 : $jobName.hashCode());
		final Object $byUserUsername = this.getByUserUsername();
		result = result * PRIME + ($byUserUsername == null ? 43 : $byUserUsername.hashCode());
		final Object $byUserUsernameImageUrl = this.getByUserUsernameImageUrl();
		result = result * PRIME + ($byUserUsernameImageUrl == null ? 43 : $byUserUsernameImageUrl.hashCode());
		final Object $onUserUsername = this.getOnUserUsername();
		result = result * PRIME + ($onUserUsername == null ? 43 : $onUserUsername.hashCode());
		final Object $onUserUsernameImageUrl = this.getOnUserUsernameImageUrl();
		result = result * PRIME + ($onUserUsernameImageUrl == null ? 43 : $onUserUsernameImageUrl.hashCode());
		final Object $type = this.getType();
		result = result * PRIME + ($type == null ? 43 : $type.hashCode());
		result = result * PRIME + this.getRating();
		final Object $publishDate = this.getPublishDate();
		result = result * PRIME + ($publishDate == null ? 43 : $publishDate.hashCode());
		final Object $updateDate = this.getUpdateDate();
		result = result * PRIME + ($updateDate == null ? 43 : $updateDate.hashCode());
		final Object $reviewText = this.getReviewText();
		result = result * PRIME + ($reviewText == null ? 43 : $reviewText.hashCode());
		return result;
	}

	public String toString() {
		return "JobReviewDto(id=" + this.getId() + ", jobId=" + this.getJobId() + ", jobName=" + this.getJobName() + ", byUserUsername=" + this.getByUserUsername() + ", byUserUsernameImageUrl=" + this.getByUserUsernameImageUrl() + ", onUserUsername=" + this.getOnUserUsername() + ", onUserUsernameImageUrl=" + this.getOnUserUsernameImageUrl() + ", type=" + this.getType() + ", rating=" + this.getRating() + ", publishDate=" + this.getPublishDate() + ", updateDate=" + this.getUpdateDate() + ", reviewText=" + this.getReviewText() + ")";
	}

	public static class JobReviewDtoBuilder {
		private Long id;
		private Long jobId;
		private String jobName;
		private String byUserUsername;
		private String byUserUsernameImageUrl;
		private String onUserUsername;
		private String onUserUsernameImageUrl;
		private JobReviewType type;
		private @Min(value = 1, message = "Ratting Cannot Be Less Than 1")
		@Max(value = 5, message = "Ratting Cannot Be More Than 5")
		@NotNull(message = "Ratting Cannot Be Empty") byte rating;
		private LocalDateTime publishDate;
		private LocalDateTime updateDate;
		private @NotNull(message = "Review Text Cannot Be Empty")
		@Size(min = 15, max = 512, message = "Description Field Cannot Be Less Than 15 Or bigger Than 512") String reviewText;

		JobReviewDtoBuilder() {
		}

		public JobReviewDtoBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public JobReviewDtoBuilder jobId(Long jobId) {
			this.jobId = jobId;
			return this;
		}

		public JobReviewDtoBuilder jobName(String jobName) {
			this.jobName = jobName;
			return this;
		}

		public JobReviewDtoBuilder byUserUsername(String byUserUsername) {
			this.byUserUsername = byUserUsername;
			return this;
		}

		public JobReviewDtoBuilder byUserUsernameImageUrl(String byUserUsernameImageUrl) {
			this.byUserUsernameImageUrl = byUserUsernameImageUrl;
			return this;
		}

		public JobReviewDtoBuilder onUserUsername(String onUserUsername) {
			this.onUserUsername = onUserUsername;
			return this;
		}

		public JobReviewDtoBuilder onUserUsernameImageUrl(String onUserUsernameImageUrl) {
			this.onUserUsernameImageUrl = onUserUsernameImageUrl;
			return this;
		}

		public JobReviewDtoBuilder type(JobReviewType type) {
			this.type = type;
			return this;
		}

		public JobReviewDtoBuilder rating(@Min(value = 1, message = "Ratting Cannot Be Less Than 1") @Max(value = 5, message = "Ratting Cannot Be More Than 5") @NotNull(message = "Ratting Cannot Be Empty") byte rating) {
			this.rating = rating;
			return this;
		}

		public JobReviewDtoBuilder publishDate(LocalDateTime publishDate) {
			this.publishDate = publishDate;
			return this;
		}

		public JobReviewDtoBuilder updateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public JobReviewDtoBuilder reviewText(@NotNull(message = "Review Text Cannot Be Empty") @Size(min = 15, max = 512, message = "Description Field Cannot Be Less Than 15 Or bigger Than 512") String reviewText) {
			this.reviewText = reviewText;
			return this;
		}

		public JobReviewDto build() {
			return new JobReviewDto(this.id, this.jobId, this.jobName, this.byUserUsername, this.byUserUsernameImageUrl, this.onUserUsername, this.onUserUsernameImageUrl, this.type, this.rating, this.publishDate, this.updateDate, this.reviewText);
		}

		public String toString() {
			return "JobReviewDto.JobReviewDtoBuilder(id=" + this.id + ", jobId=" + this.jobId + ", jobName=" + this.jobName + ", byUserUsername=" + this.byUserUsername + ", byUserUsernameImageUrl=" + this.byUserUsernameImageUrl + ", onUserUsername=" + this.onUserUsername + ", onUserUsernameImageUrl=" + this.onUserUsernameImageUrl + ", type=" + this.type + ", rating=" + this.rating + ", publishDate=" + this.publishDate + ", updateDate=" + this.updateDate + ", reviewText=" + this.reviewText + ")";
		}
	}
}
