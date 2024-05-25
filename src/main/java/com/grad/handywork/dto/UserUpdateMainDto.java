package com.grad.handywork.dto;

import com.grad.handywork.enumtypes.Cities;
import jakarta.validation.constraints.*;

public class UserUpdateMainDto {

	@NotNull(message = "First Name Field Cannot Be Empty")
	@Size(min = 3, max = 36, message = "First Name Field Must be between 3 and 36")
	private String firstName;

	@NotNull(message = "First Name Field Cannot Be Empty")
	@Size(min = 3, max = 36, message = "Last Name Field Must be between 3 and 36")
	private String lastName;

	@NotEmpty(message = "Email Field Cannot be empty")
	@Email(message = "Please Enter A Valid Email")
	private String email;

	@NotEmpty(message = "Phone Number Field Cannot be empty")
	@Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number")
	private String phoneNumber;

	@NotNull(message = "City Field Cannot be empty")
	private Cities city;

	public UserUpdateMainDto(@NotNull(message = "First Name Field Cannot Be Empty") @Size(min = 3, max = 36, message = "First Name Field Must be between 3 and 36") String firstName, @NotNull(message = "First Name Field Cannot Be Empty") @Size(min = 3, max = 36, message = "Last Name Field Must be between 3 and 36") String lastName, @NotEmpty(message = "Email Field Cannot be empty") @Email(message = "Please Enter A Valid Email") String email, @NotEmpty(message = "Phone Number Field Cannot be empty") @Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number") String phoneNumber, @NotNull(message = "City Field Cannot be empty") Cities city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
	}

	public UserUpdateMainDto() {
	}

	public static UserUpdateMainDtoBuilder builder() {
		return new UserUpdateMainDtoBuilder();
	}

	public @NotNull(message = "First Name Field Cannot Be Empty") @Size(min = 3, max = 36, message = "First Name Field Must be between 3 and 36") String getFirstName() {
		return this.firstName;
	}

	public @NotNull(message = "First Name Field Cannot Be Empty") @Size(min = 3, max = 36, message = "Last Name Field Must be between 3 and 36") String getLastName() {
		return this.lastName;
	}

	public @NotEmpty(message = "Email Field Cannot be empty") @Email(message = "Please Enter A Valid Email") String getEmail() {
		return this.email;
	}

	public @NotEmpty(message = "Phone Number Field Cannot be empty") @Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number") String getPhoneNumber() {
		return this.phoneNumber;
	}

	public @NotNull(message = "City Field Cannot be empty") Cities getCity() {
		return this.city;
	}

	public void setFirstName(@NotNull(message = "First Name Field Cannot Be Empty") @Size(min = 3, max = 36, message = "First Name Field Must be between 3 and 36") String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(@NotNull(message = "First Name Field Cannot Be Empty") @Size(min = 3, max = 36, message = "Last Name Field Must be between 3 and 36") String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(@NotEmpty(message = "Email Field Cannot be empty") @Email(message = "Please Enter A Valid Email") String email) {
		this.email = email;
	}

	public void setPhoneNumber(@NotEmpty(message = "Phone Number Field Cannot be empty") @Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number") String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setCity(@NotNull(message = "City Field Cannot be empty") Cities city) {
		this.city = city;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof UserUpdateMainDto)) return false;
		final UserUpdateMainDto other = (UserUpdateMainDto) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$firstName = this.getFirstName();
		final Object other$firstName = other.getFirstName();
		if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
		final Object this$lastName = this.getLastName();
		final Object other$lastName = other.getLastName();
		if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
		final Object this$email = this.getEmail();
		final Object other$email = other.getEmail();
		if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
		final Object this$phoneNumber = this.getPhoneNumber();
		final Object other$phoneNumber = other.getPhoneNumber();
		if (this$phoneNumber == null ? other$phoneNumber != null : !this$phoneNumber.equals(other$phoneNumber))
			return false;
		final Object this$city = this.getCity();
		final Object other$city = other.getCity();
		if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof UserUpdateMainDto;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $firstName = this.getFirstName();
		result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
		final Object $lastName = this.getLastName();
		result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
		final Object $email = this.getEmail();
		result = result * PRIME + ($email == null ? 43 : $email.hashCode());
		final Object $phoneNumber = this.getPhoneNumber();
		result = result * PRIME + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
		final Object $city = this.getCity();
		result = result * PRIME + ($city == null ? 43 : $city.hashCode());
		return result;
	}

	public String toString() {
		return "UserUpdateMainDto(firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", email=" + this.getEmail() + ", phoneNumber=" + this.getPhoneNumber() + ", city=" + this.getCity() + ")";
	}

	public static class UserUpdateMainDtoBuilder {
		private @NotNull(message = "First Name Field Cannot Be Empty")
		@Size(min = 3, max = 36, message = "First Name Field Must be between 3 and 36") String firstName;
		private @NotNull(message = "First Name Field Cannot Be Empty")
		@Size(min = 3, max = 36, message = "Last Name Field Must be between 3 and 36") String lastName;
		private @NotEmpty(message = "Email Field Cannot be empty")
		@Email(message = "Please Enter A Valid Email") String email;
		private @NotEmpty(message = "Phone Number Field Cannot be empty")
		@Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number") String phoneNumber;
		private @NotNull(message = "City Field Cannot be empty") Cities city;

		UserUpdateMainDtoBuilder() {
		}

		public UserUpdateMainDtoBuilder firstName(@NotNull(message = "First Name Field Cannot Be Empty") @Size(min = 3, max = 36, message = "First Name Field Must be between 3 and 36") String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserUpdateMainDtoBuilder lastName(@NotNull(message = "First Name Field Cannot Be Empty") @Size(min = 3, max = 36, message = "Last Name Field Must be between 3 and 36") String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserUpdateMainDtoBuilder email(@NotEmpty(message = "Email Field Cannot be empty") @Email(message = "Please Enter A Valid Email") String email) {
			this.email = email;
			return this;
		}

		public UserUpdateMainDtoBuilder phoneNumber(@NotEmpty(message = "Phone Number Field Cannot be empty") @Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number") String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public UserUpdateMainDtoBuilder city(@NotNull(message = "City Field Cannot be empty") Cities city) {
			this.city = city;
			return this;
		}

		public UserUpdateMainDto build() {
			return new UserUpdateMainDto(this.firstName, this.lastName, this.email, this.phoneNumber, this.city);
		}

		public String toString() {
			return "UserUpdateMainDto.UserUpdateMainDtoBuilder(firstName=" + this.firstName + ", lastName=" + this.lastName + ", email=" + this.email + ", phoneNumber=" + this.phoneNumber + ", city=" + this.city + ")";
		}
	}
}
