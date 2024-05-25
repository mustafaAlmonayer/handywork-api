package com.grad.handywork.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grad.handywork.validation.UniqueEmail;
import com.grad.handywork.validation.UniquePhoneNumber;
import com.grad.handywork.validation.UniqueUsername;
import jakarta.validation.constraints.*;

@JsonInclude(Include.NON_NULL)
public class UserDto {

	private Long id;

	@NotNull(message = "Username Field Cannot Be Empty")
	@Size(min = 4, max = 36, message = "Username Field Must Be Between 4 And 36")
	@UniqueUsername
	private String username;

	@NotNull(message = "Password Field Cannot Be Empty")
	@Size(min = 8, message = "Password Field Must Be 8 Or More")
	private String password;

	@JsonInclude(value = Include.ALWAYS)
	@Size(min = 3, max = 36, message = "First Name Field Must be between 3 and 36")
	private String firstName;

	@JsonInclude(value = Include.ALWAYS)
	@Size(min = 3, max = 36, message = "Last Name Field Must be between 3 and 36")
	private String lastName;

	@NotEmpty(message = "Email Field Cannot be empty")
	@Email(message = "Please Enter A Valid Email")
	@UniqueEmail
	private String email;

	@NotEmpty(message = "Phone Number Field Cannot be empty")
	@Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number")
	@UniquePhoneNumber
	private String phoneNumber;

	private String pfpUrl;

	@NotNull(message = "City Field Cannot be empty")
	private String city;

	private String pfpFile;

	public UserDto(Long id, @NotNull(message = "Username Field Cannot Be Empty") @Size(min = 4, max = 36, message = "Username Field Must Be Between 4 And 36") String username, @NotNull(message = "Password Field Cannot Be Empty") @Size(min = 8, message = "Password Field Must Be 8 Or More") String password, @Size(min = 3, max = 36, message = "First Name Field Must be between 3 and 36") String firstName, @Size(min = 3, max = 36, message = "Last Name Field Must be between 3 and 36") String lastName, @NotEmpty(message = "Email Field Cannot be empty") @Email(message = "Please Enter A Valid Email") String email, @NotEmpty(message = "Phone Number Field Cannot be empty") @Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number") String phoneNumber, String pfpUrl, @NotNull(message = "City Field Cannot be empty") String city, String pfpFile) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.pfpUrl = pfpUrl;
		this.city = city;
		this.pfpFile = pfpFile;
	}

	public UserDto() {
	}

	public static UserDtoBuilder builder() {
		return new UserDtoBuilder();
	}

	public Long getId() {
		return this.id;
	}

	public @NotNull(message = "Username Field Cannot Be Empty") @Size(min = 4, max = 36, message = "Username Field Must Be Between 4 And 36") String getUsername() {
		return this.username;
	}

	public @NotNull(message = "Password Field Cannot Be Empty") @Size(min = 8, message = "Password Field Must Be 8 Or More") String getPassword() {
		return this.password;
	}

	public @Size(min = 3, max = 36, message = "First Name Field Must be between 3 and 36") String getFirstName() {
		return this.firstName;
	}

	public @Size(min = 3, max = 36, message = "Last Name Field Must be between 3 and 36") String getLastName() {
		return this.lastName;
	}

	public @NotEmpty(message = "Email Field Cannot be empty") @Email(message = "Please Enter A Valid Email") String getEmail() {
		return this.email;
	}

	public @NotEmpty(message = "Phone Number Field Cannot be empty") @Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number") String getPhoneNumber() {
		return this.phoneNumber;
	}

	public String getPfpUrl() {
		return this.pfpUrl;
	}

	public @NotNull(message = "City Field Cannot be empty") String getCity() {
		return this.city;
	}

	public String getPfpFile() {
		return this.pfpFile;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(@NotNull(message = "Username Field Cannot Be Empty") @Size(min = 4, max = 36, message = "Username Field Must Be Between 4 And 36") String username) {
		this.username = username;
	}

	public void setPassword(@NotNull(message = "Password Field Cannot Be Empty") @Size(min = 8, message = "Password Field Must Be 8 Or More") String password) {
		this.password = password;
	}

	public void setFirstName(@Size(min = 3, max = 36, message = "First Name Field Must be between 3 and 36") String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(@Size(min = 3, max = 36, message = "Last Name Field Must be between 3 and 36") String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(@NotEmpty(message = "Email Field Cannot be empty") @Email(message = "Please Enter A Valid Email") String email) {
		this.email = email;
	}

	public void setPhoneNumber(@NotEmpty(message = "Phone Number Field Cannot be empty") @Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number") String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPfpUrl(String pfpUrl) {
		this.pfpUrl = pfpUrl;
	}

	public void setCity(@NotNull(message = "City Field Cannot be empty") String city) {
		this.city = city;
	}

	public void setPfpFile(String pfpFile) {
		this.pfpFile = pfpFile;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof UserDto)) return false;
		final UserDto other = (UserDto) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$id = this.getId();
		final Object other$id = other.getId();
		if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
		final Object this$username = this.getUsername();
		final Object other$username = other.getUsername();
		if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
		final Object this$password = this.getPassword();
		final Object other$password = other.getPassword();
		if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
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
		final Object this$pfpUrl = this.getPfpUrl();
		final Object other$pfpUrl = other.getPfpUrl();
		if (this$pfpUrl == null ? other$pfpUrl != null : !this$pfpUrl.equals(other$pfpUrl)) return false;
		final Object this$city = this.getCity();
		final Object other$city = other.getCity();
		if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
		final Object this$pfpFile = this.getPfpFile();
		final Object other$pfpFile = other.getPfpFile();
		if (this$pfpFile == null ? other$pfpFile != null : !this$pfpFile.equals(other$pfpFile)) return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof UserDto;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $id = this.getId();
		result = result * PRIME + ($id == null ? 43 : $id.hashCode());
		final Object $username = this.getUsername();
		result = result * PRIME + ($username == null ? 43 : $username.hashCode());
		final Object $password = this.getPassword();
		result = result * PRIME + ($password == null ? 43 : $password.hashCode());
		final Object $firstName = this.getFirstName();
		result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
		final Object $lastName = this.getLastName();
		result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
		final Object $email = this.getEmail();
		result = result * PRIME + ($email == null ? 43 : $email.hashCode());
		final Object $phoneNumber = this.getPhoneNumber();
		result = result * PRIME + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
		final Object $pfpUrl = this.getPfpUrl();
		result = result * PRIME + ($pfpUrl == null ? 43 : $pfpUrl.hashCode());
		final Object $city = this.getCity();
		result = result * PRIME + ($city == null ? 43 : $city.hashCode());
		final Object $pfpFile = this.getPfpFile();
		result = result * PRIME + ($pfpFile == null ? 43 : $pfpFile.hashCode());
		return result;
	}

	public String toString() {
		return "UserDto(id=" + this.getId() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", email=" + this.getEmail() + ", phoneNumber=" + this.getPhoneNumber() + ", pfpUrl=" + this.getPfpUrl() + ", city=" + this.getCity() + ", pfpFile=" + this.getPfpFile() + ")";
	}

	public static class UserDtoBuilder {
		private Long id;
		private @NotNull(message = "Username Field Cannot Be Empty")
		@Size(min = 4, max = 36, message = "Username Field Must Be Between 4 And 36") String username;
		private @NotNull(message = "Password Field Cannot Be Empty")
		@Size(min = 8, message = "Password Field Must Be 8 Or More") String password;
		private @Size(min = 3, max = 36, message = "First Name Field Must be between 3 and 36") String firstName;
		private @Size(min = 3, max = 36, message = "Last Name Field Must be between 3 and 36") String lastName;
		private @NotEmpty(message = "Email Field Cannot be empty")
		@Email(message = "Please Enter A Valid Email") String email;
		private @NotEmpty(message = "Phone Number Field Cannot be empty")
		@Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number") String phoneNumber;
		private String pfpUrl;
		private @NotNull(message = "City Field Cannot be empty") String city;
		private String pfpFile;

		UserDtoBuilder() {
		}

		public UserDtoBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public UserDtoBuilder username(@NotNull(message = "Username Field Cannot Be Empty") @Size(min = 4, max = 36, message = "Username Field Must Be Between 4 And 36") String username) {
			this.username = username;
			return this;
		}

		public UserDtoBuilder password(@NotNull(message = "Password Field Cannot Be Empty") @Size(min = 8, message = "Password Field Must Be 8 Or More") String password) {
			this.password = password;
			return this;
		}

		public UserDtoBuilder firstName(@Size(min = 3, max = 36, message = "First Name Field Must be between 3 and 36") String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserDtoBuilder lastName(@Size(min = 3, max = 36, message = "Last Name Field Must be between 3 and 36") String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserDtoBuilder email(@NotEmpty(message = "Email Field Cannot be empty") @Email(message = "Please Enter A Valid Email") String email) {
			this.email = email;
			return this;
		}

		public UserDtoBuilder phoneNumber(@NotEmpty(message = "Phone Number Field Cannot be empty") @Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number") String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public UserDtoBuilder pfpUrl(String pfpUrl) {
			this.pfpUrl = pfpUrl;
			return this;
		}

		public UserDtoBuilder city(@NotNull(message = "City Field Cannot be empty") String city) {
			this.city = city;
			return this;
		}

		public UserDtoBuilder pfpFile(String pfpFile) {
			this.pfpFile = pfpFile;
			return this;
		}

		public UserDto build() {
			return new UserDto(this.id, this.username, this.password, this.firstName, this.lastName, this.email, this.phoneNumber, this.pfpUrl, this.city, this.pfpFile);
		}

		public String toString() {
			return "UserDto.UserDtoBuilder(id=" + this.id + ", username=" + this.username + ", password=" + this.password + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", email=" + this.email + ", phoneNumber=" + this.phoneNumber + ", pfpUrl=" + this.pfpUrl + ", city=" + this.city + ", pfpFile=" + this.pfpFile + ")";
		}
	}
}
