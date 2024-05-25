package com.grad.handywork.dto;

import com.grad.handywork.enumtypes.Cities;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class JobUpdateDto {

	@NotNull(message = "Cannot Be Empty")
	private String jobName;

	@Size(min = 15, message = "Description Field Cannot Be Less Than 15")
	private String description;

	@NotNull(message = "City Cannot Be Empty")
	private Cities city;

	@NotNull(message = "\"Field\" Field cannot be empty")
	private String field;

	public JobUpdateDto(@NotNull(message = "Cannot Be Empty") String jobName, @Size(min = 15, message = "Description Field Cannot Be Less Than 15") String description, @NotNull(message = "City Cannot Be Empty") Cities city, @NotNull(message = "\"Field\" Field cannot be empty") String field) {
		this.jobName = jobName;
		this.description = description;
		this.city = city;
		this.field = field;
	}

	public JobUpdateDto() {
	}

	public static JobUpdateDtoBuilder builder() {
		return new JobUpdateDtoBuilder();
	}

	public @NotNull(message = "Cannot Be Empty") String getJobName() {
		return this.jobName;
	}

	public @Size(min = 15, message = "Description Field Cannot Be Less Than 15") String getDescription() {
		return this.description;
	}

	public @NotNull(message = "City Cannot Be Empty") Cities getCity() {
		return this.city;
	}

	public @NotNull(message = "\"Field\" Field cannot be empty") String getField() {
		return this.field;
	}

	public void setJobName(@NotNull(message = "Cannot Be Empty") String jobName) {
		this.jobName = jobName;
	}

	public void setDescription(@Size(min = 15, message = "Description Field Cannot Be Less Than 15") String description) {
		this.description = description;
	}

	public void setCity(@NotNull(message = "City Cannot Be Empty") Cities city) {
		this.city = city;
	}

	public void setField(@NotNull(message = "\"Field\" Field cannot be empty") String field) {
		this.field = field;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof JobUpdateDto)) return false;
		final JobUpdateDto other = (JobUpdateDto) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$jobName = this.getJobName();
		final Object other$jobName = other.getJobName();
		if (this$jobName == null ? other$jobName != null : !this$jobName.equals(other$jobName)) return false;
		final Object this$description = this.getDescription();
		final Object other$description = other.getDescription();
		if (this$description == null ? other$description != null : !this$description.equals(other$description))
			return false;
		final Object this$city = this.getCity();
		final Object other$city = other.getCity();
		if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
		final Object this$field = this.getField();
		final Object other$field = other.getField();
		if (this$field == null ? other$field != null : !this$field.equals(other$field)) return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof JobUpdateDto;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $jobName = this.getJobName();
		result = result * PRIME + ($jobName == null ? 43 : $jobName.hashCode());
		final Object $description = this.getDescription();
		result = result * PRIME + ($description == null ? 43 : $description.hashCode());
		final Object $city = this.getCity();
		result = result * PRIME + ($city == null ? 43 : $city.hashCode());
		final Object $field = this.getField();
		result = result * PRIME + ($field == null ? 43 : $field.hashCode());
		return result;
	}

	public String toString() {
		return "JobUpdateDto(jobName=" + this.getJobName() + ", description=" + this.getDescription() + ", city=" + this.getCity() + ", field=" + this.getField() + ")";
	}

	public static class JobUpdateDtoBuilder {
		private @NotNull(message = "Cannot Be Empty") String jobName;
		private @Size(min = 15, message = "Description Field Cannot Be Less Than 15") String description;
		private @NotNull(message = "City Cannot Be Empty") Cities city;
		private @NotNull(message = "\"Field\" Field cannot be empty") String field;

		JobUpdateDtoBuilder() {
		}

		public JobUpdateDtoBuilder jobName(@NotNull(message = "Cannot Be Empty") String jobName) {
			this.jobName = jobName;
			return this;
		}

		public JobUpdateDtoBuilder description(@Size(min = 15, message = "Description Field Cannot Be Less Than 15") String description) {
			this.description = description;
			return this;
		}

		public JobUpdateDtoBuilder city(@NotNull(message = "City Cannot Be Empty") Cities city) {
			this.city = city;
			return this;
		}

		public JobUpdateDtoBuilder field(@NotNull(message = "\"Field\" Field cannot be empty") String field) {
			this.field = field;
			return this;
		}

		public JobUpdateDto build() {
			return new JobUpdateDto(this.jobName, this.description, this.city, this.field);
		}

		public String toString() {
			return "JobUpdateDto.JobUpdateDtoBuilder(jobName=" + this.jobName + ", description=" + this.description + ", city=" + this.city + ", field=" + this.field + ")";
		}
	}
}
