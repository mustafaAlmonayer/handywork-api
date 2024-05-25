package com.grad.handywork.dto;

import java.util.List;

public class AllJobsDto {

	private List<JobDto> jobs;

	private Integer numOfPages;

	public AllJobsDto(List<JobDto> jobs, Integer numOfPages) {
		this.jobs = jobs;
		this.numOfPages = numOfPages;
	}

	public AllJobsDto() {
	}

	public static AllJobsDtoBuilder builder() {
		return new AllJobsDtoBuilder();
	}

	public List<JobDto> getJobs() {
		return this.jobs;
	}

	public Integer getNumOfPages() {
		return this.numOfPages;
	}

	public void setJobs(List<JobDto> jobs) {
		this.jobs = jobs;
	}

	public void setNumOfPages(Integer numOfPages) {
		this.numOfPages = numOfPages;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof AllJobsDto)) return false;
		final AllJobsDto other = (AllJobsDto) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$jobs = this.getJobs();
		final Object other$jobs = other.getJobs();
		if (this$jobs == null ? other$jobs != null : !this$jobs.equals(other$jobs)) return false;
		final Object this$numOfPages = this.getNumOfPages();
		final Object other$numOfPages = other.getNumOfPages();
		if (this$numOfPages == null ? other$numOfPages != null : !this$numOfPages.equals(other$numOfPages))
			return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof AllJobsDto;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $jobs = this.getJobs();
		result = result * PRIME + ($jobs == null ? 43 : $jobs.hashCode());
		final Object $numOfPages = this.getNumOfPages();
		result = result * PRIME + ($numOfPages == null ? 43 : $numOfPages.hashCode());
		return result;
	}

	public String toString() {
		return "AllJobsDto(jobs=" + this.getJobs() + ", numOfPages=" + this.getNumOfPages() + ")";
	}

	public static class AllJobsDtoBuilder {
		private List<JobDto> jobs;
		private Integer numOfPages;

		AllJobsDtoBuilder() {
		}

		public AllJobsDtoBuilder jobs(List<JobDto> jobs) {
			this.jobs = jobs;
			return this;
		}

		public AllJobsDtoBuilder numOfPages(Integer numOfPages) {
			this.numOfPages = numOfPages;
			return this;
		}

		public AllJobsDto build() {
			return new AllJobsDto(this.jobs, this.numOfPages);
		}

		public String toString() {
			return "AllJobsDto.AllJobsDtoBuilder(jobs=" + this.jobs + ", numOfPages=" + this.numOfPages + ")";
		}
	}
}
