package com.grad.handywork.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PasswordDto {

	@NotNull(message = "Password Field Cannot Be Empty")
	@Size(min = 8, message = "Password Field Be 8 Or More")
	private String password;

	private String encodedPassword;

	public PasswordDto(@NotNull(message = "Password Field Cannot Be Empty") @Size(min = 8, message = "Password Field Be 8 Or More") String password, String encodedPassword) {
		this.password = password;
		this.encodedPassword = encodedPassword;
	}

	public PasswordDto() {
	}

	public static PasswordDtoBuilder builder() {
		return new PasswordDtoBuilder();
	}

	public @NotNull(message = "Password Field Cannot Be Empty") @Size(min = 8, message = "Password Field Be 8 Or More") String getPassword() {
		return this.password;
	}

	public String getEncodedPassword() {
		return this.encodedPassword;
	}

	public void setPassword(@NotNull(message = "Password Field Cannot Be Empty") @Size(min = 8, message = "Password Field Be 8 Or More") String password) {
		this.password = password;
	}

	public void setEncodedPassword(String encodedPassword) {
		this.encodedPassword = encodedPassword;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof PasswordDto)) return false;
		final PasswordDto other = (PasswordDto) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$password = this.getPassword();
		final Object other$password = other.getPassword();
		if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
		final Object this$encodedPassword = this.getEncodedPassword();
		final Object other$encodedPassword = other.getEncodedPassword();
		if (this$encodedPassword == null ? other$encodedPassword != null : !this$encodedPassword.equals(other$encodedPassword))
			return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof PasswordDto;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $password = this.getPassword();
		result = result * PRIME + ($password == null ? 43 : $password.hashCode());
		final Object $encodedPassword = this.getEncodedPassword();
		result = result * PRIME + ($encodedPassword == null ? 43 : $encodedPassword.hashCode());
		return result;
	}

	public String toString() {
		return "PasswordDto(password=" + this.getPassword() + ", encodedPassword=" + this.getEncodedPassword() + ")";
	}

	public static class PasswordDtoBuilder {
		private @NotNull(message = "Password Field Cannot Be Empty")
		@Size(min = 8, message = "Password Field Be 8 Or More") String password;
		private String encodedPassword;

		PasswordDtoBuilder() {
		}

		public PasswordDtoBuilder password(@NotNull(message = "Password Field Cannot Be Empty") @Size(min = 8, message = "Password Field Be 8 Or More") String password) {
			this.password = password;
			return this;
		}

		public PasswordDtoBuilder encodedPassword(String encodedPassword) {
			this.encodedPassword = encodedPassword;
			return this;
		}

		public PasswordDto build() {
			return new PasswordDto(this.password, this.encodedPassword);
		}

		public String toString() {
			return "PasswordDto.PasswordDtoBuilder(password=" + this.password + ", encodedPassword=" + this.encodedPassword + ")";
		}
	}
}
