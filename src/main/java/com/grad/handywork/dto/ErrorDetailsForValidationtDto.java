package com.grad.handywork.dto;

import java.util.Map;

public class ErrorDetailsForValidationtDto {

	private Map<String, String> message;

	public ErrorDetailsForValidationtDto(Map<String, String> message) {
		this.message = message;
	}

	public ErrorDetailsForValidationtDto() {
	}

	public static ErrorDetailsForValidationtDtoBuilder builder() {
		return new ErrorDetailsForValidationtDtoBuilder();
	}

	public Map<String, String> getMessage() {
		return this.message;
	}

	public void setMessage(Map<String, String> message) {
		this.message = message;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof ErrorDetailsForValidationtDto)) return false;
		final ErrorDetailsForValidationtDto other = (ErrorDetailsForValidationtDto) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$message = this.getMessage();
		final Object other$message = other.getMessage();
		if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof ErrorDetailsForValidationtDto;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $message = this.getMessage();
		result = result * PRIME + ($message == null ? 43 : $message.hashCode());
		return result;
	}

	public String toString() {
		return "ErrorDetailsForValidationtDto(message=" + this.getMessage() + ")";
	}

	public static class ErrorDetailsForValidationtDtoBuilder {
		private Map<String, String> message;

		ErrorDetailsForValidationtDtoBuilder() {
		}

		public ErrorDetailsForValidationtDtoBuilder message(Map<String, String> message) {
			this.message = message;
			return this;
		}

		public ErrorDetailsForValidationtDto build() {
			return new ErrorDetailsForValidationtDto(this.message);
		}

		public String toString() {
			return "ErrorDetailsForValidationtDto.ErrorDetailsForValidationtDtoBuilder(message=" + this.message + ")";
		}
	}
}
