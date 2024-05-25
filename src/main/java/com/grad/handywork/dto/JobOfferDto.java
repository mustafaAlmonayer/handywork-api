package com.grad.handywork.dto;

import jakarta.validation.constraints.NotNull;

public class JobOfferDto {

	private Long id;

	private String jobTitle;

	private Long jobId;

	private String jobImageUrl;

	private String user;

	private String userImageUrl;

	@NotNull(message = "Amount Cannot Be Empty")
	private Integer suggestedAmount;

	private Boolean accepted;

	private Boolean rejected;

	public JobOfferDto(Long id, String jobTitle, Long jobId, String jobImageUrl, String user, String userImageUrl, @NotNull(message = "Amount Cannot Be Empty") Integer suggestedAmount, Boolean accepted, Boolean rejected) {
		this.id = id;
		this.jobTitle = jobTitle;
		this.jobId = jobId;
		this.jobImageUrl = jobImageUrl;
		this.user = user;
		this.userImageUrl = userImageUrl;
		this.suggestedAmount = suggestedAmount;
		this.accepted = accepted;
		this.rejected = rejected;
	}

	public JobOfferDto() {
	}

	public static JobOfferDtoBuilder builder() {
		return new JobOfferDtoBuilder();
	}

	public Long getId() {
		return this.id;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public Long getJobId() {
		return this.jobId;
	}

	public String getJobImageUrl() {
		return this.jobImageUrl;
	}

	public String getUser() {
		return this.user;
	}

	public String getUserImageUrl() {
		return this.userImageUrl;
	}

	public @NotNull(message = "Amount Cannot Be Empty") Integer getSuggestedAmount() {
		return this.suggestedAmount;
	}

	public Boolean getAccepted() {
		return this.accepted;
	}

	public Boolean getRejected() {
		return this.rejected;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public void setJobImageUrl(String jobImageUrl) {
		this.jobImageUrl = jobImageUrl;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setUserImageUrl(String userImageUrl) {
		this.userImageUrl = userImageUrl;
	}

	public void setSuggestedAmount(@NotNull(message = "Amount Cannot Be Empty") Integer suggestedAmount) {
		this.suggestedAmount = suggestedAmount;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public void setRejected(Boolean rejected) {
		this.rejected = rejected;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof JobOfferDto)) return false;
		final JobOfferDto other = (JobOfferDto) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$id = this.getId();
		final Object other$id = other.getId();
		if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
		final Object this$jobTitle = this.getJobTitle();
		final Object other$jobTitle = other.getJobTitle();
		if (this$jobTitle == null ? other$jobTitle != null : !this$jobTitle.equals(other$jobTitle)) return false;
		final Object this$jobId = this.getJobId();
		final Object other$jobId = other.getJobId();
		if (this$jobId == null ? other$jobId != null : !this$jobId.equals(other$jobId)) return false;
		final Object this$jobImageUrl = this.getJobImageUrl();
		final Object other$jobImageUrl = other.getJobImageUrl();
		if (this$jobImageUrl == null ? other$jobImageUrl != null : !this$jobImageUrl.equals(other$jobImageUrl))
			return false;
		final Object this$user = this.getUser();
		final Object other$user = other.getUser();
		if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
		final Object this$userImageUrl = this.getUserImageUrl();
		final Object other$userImageUrl = other.getUserImageUrl();
		if (this$userImageUrl == null ? other$userImageUrl != null : !this$userImageUrl.equals(other$userImageUrl))
			return false;
		final Object this$suggestedAmount = this.getSuggestedAmount();
		final Object other$suggestedAmount = other.getSuggestedAmount();
		if (this$suggestedAmount == null ? other$suggestedAmount != null : !this$suggestedAmount.equals(other$suggestedAmount))
			return false;
		final Object this$accepted = this.getAccepted();
		final Object other$accepted = other.getAccepted();
		if (this$accepted == null ? other$accepted != null : !this$accepted.equals(other$accepted)) return false;
		final Object this$rejected = this.getRejected();
		final Object other$rejected = other.getRejected();
		if (this$rejected == null ? other$rejected != null : !this$rejected.equals(other$rejected)) return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof JobOfferDto;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $id = this.getId();
		result = result * PRIME + ($id == null ? 43 : $id.hashCode());
		final Object $jobTitle = this.getJobTitle();
		result = result * PRIME + ($jobTitle == null ? 43 : $jobTitle.hashCode());
		final Object $jobId = this.getJobId();
		result = result * PRIME + ($jobId == null ? 43 : $jobId.hashCode());
		final Object $jobImageUrl = this.getJobImageUrl();
		result = result * PRIME + ($jobImageUrl == null ? 43 : $jobImageUrl.hashCode());
		final Object $user = this.getUser();
		result = result * PRIME + ($user == null ? 43 : $user.hashCode());
		final Object $userImageUrl = this.getUserImageUrl();
		result = result * PRIME + ($userImageUrl == null ? 43 : $userImageUrl.hashCode());
		final Object $suggestedAmount = this.getSuggestedAmount();
		result = result * PRIME + ($suggestedAmount == null ? 43 : $suggestedAmount.hashCode());
		final Object $accepted = this.getAccepted();
		result = result * PRIME + ($accepted == null ? 43 : $accepted.hashCode());
		final Object $rejected = this.getRejected();
		result = result * PRIME + ($rejected == null ? 43 : $rejected.hashCode());
		return result;
	}

	public String toString() {
		return "JobOfferDto(id=" + this.getId() + ", jobTitle=" + this.getJobTitle() + ", jobId=" + this.getJobId() + ", jobImageUrl=" + this.getJobImageUrl() + ", user=" + this.getUser() + ", userImageUrl=" + this.getUserImageUrl() + ", suggestedAmount=" + this.getSuggestedAmount() + ", accepted=" + this.getAccepted() + ", rejected=" + this.getRejected() + ")";
	}

	public static class JobOfferDtoBuilder {
		private Long id;
		private String jobTitle;
		private Long jobId;
		private String jobImageUrl;
		private String user;
		private String userImageUrl;
		private @NotNull(message = "Amount Cannot Be Empty") Integer suggestedAmount;
		private Boolean accepted;
		private Boolean rejected;

		JobOfferDtoBuilder() {
		}

		public JobOfferDtoBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public JobOfferDtoBuilder jobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
			return this;
		}

		public JobOfferDtoBuilder jobId(Long jobId) {
			this.jobId = jobId;
			return this;
		}

		public JobOfferDtoBuilder jobImageUrl(String jobImageUrl) {
			this.jobImageUrl = jobImageUrl;
			return this;
		}

		public JobOfferDtoBuilder user(String user) {
			this.user = user;
			return this;
		}

		public JobOfferDtoBuilder userImageUrl(String userImageUrl) {
			this.userImageUrl = userImageUrl;
			return this;
		}

		public JobOfferDtoBuilder suggestedAmount(@NotNull(message = "Amount Cannot Be Empty") Integer suggestedAmount) {
			this.suggestedAmount = suggestedAmount;
			return this;
		}

		public JobOfferDtoBuilder accepted(Boolean accepted) {
			this.accepted = accepted;
			return this;
		}

		public JobOfferDtoBuilder rejected(Boolean rejected) {
			this.rejected = rejected;
			return this;
		}

		public JobOfferDto build() {
			return new JobOfferDto(this.id, this.jobTitle, this.jobId, this.jobImageUrl, this.user, this.userImageUrl, this.suggestedAmount, this.accepted, this.rejected);
		}

		public String toString() {
			return "JobOfferDto.JobOfferDtoBuilder(id=" + this.id + ", jobTitle=" + this.jobTitle + ", jobId=" + this.jobId + ", jobImageUrl=" + this.jobImageUrl + ", user=" + this.user + ", userImageUrl=" + this.userImageUrl + ", suggestedAmount=" + this.suggestedAmount + ", accepted=" + this.accepted + ", rejected=" + this.rejected + ")";
		}
	}
}
