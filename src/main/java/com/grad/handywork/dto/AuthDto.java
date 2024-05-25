package com.grad.handywork.dto;

public class AuthDto {

	private String token;

	public AuthDto(String token) {
		this.token = token;
	}

	public AuthDto() {
	}

	public static AuthDtoBuilder builder() {
		return new AuthDtoBuilder();
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof AuthDto)) return false;
		final AuthDto other = (AuthDto) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$token = this.getToken();
		final Object other$token = other.getToken();
		if (this$token == null ? other$token != null : !this$token.equals(other$token)) return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof AuthDto;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $token = this.getToken();
		result = result * PRIME + ($token == null ? 43 : $token.hashCode());
		return result;
	}

	public String toString() {
		return "AuthDto(token=" + this.getToken() + ")";
	}

	public static class AuthDtoBuilder {
		private String token;

		AuthDtoBuilder() {
		}

		public AuthDtoBuilder token(String token) {
			this.token = token;
			return this;
		}

		public AuthDto build() {
			return new AuthDto(this.token);
		}

		public String toString() {
			return "AuthDto.AuthDtoBuilder(token=" + this.token + ")";
		}
	}
}
