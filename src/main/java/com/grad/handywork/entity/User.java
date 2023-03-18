package com.grad.handywork.entity;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grad.handywork.validation.UniqueEmail;
import com.grad.handywork.validation.UniquePhoneNumber;
import com.grad.handywork.validation.UniqueUsername;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User implements UserDetails {

	@Transient
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username")
	@NotNull(message = "Username Field Cannot Be Empty")
	@Size(min = 4, max = 36, message = "Username Field Must Be Between 4 And 36")
	@UniqueUsername
	private String username;

	@Column(name = "password")
	@NotNull(message = "Password Field Cannot Be Empty")
	@Size(min = 8, message = "Password Field Be 8 Or More")
	private String password;

	@Column(name = "first_name")
	@Size(min = 3, max = 36, message = "First Name Field Must be between 3 and 36")
	private String firstName;

	@Column(name = "last_name")
	@Size(min = 3, max = 36, message = "Last Name Field Must be between 3 and 36")
	private String lastName;

	@Column(name = "email")
	@NotEmpty(message = "Email Field Cannot be empty")
	@Email(message = "Please Enter A Valid Email")
	@UniqueEmail
	private String email;

	@Column(name = "phone_number")
	@NotEmpty(message = "Phone Number Field Cannot be empty")
	@Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number")
	@UniquePhoneNumber
	private String phoneNumber;

	@Column(name = "profile_picture")
	private String pfpUrl;

	@NotNull(message = "City Field Cannot be empty")
	@Size(message = "City Field Cannot Be Less than 3")
	@Column(name = "city")
	private String city;

	@JsonIgnore
	@OneToMany(mappedBy = "owner", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	private List<Job> jobs;

	@Transient
	private String pfpFile;

	public User() {
		super();
	}

	public User(Long id, String username, String password, String firstName, String lastName, String email,
			String phoneNumber, String pfpUrl, String city, List<Job> jobs, String pfpFile) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.pfpUrl = pfpUrl;
		this.jobs = jobs;
		this.pfpFile = pfpFile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPfpUrl() {
		return pfpUrl;
	}

	public void setPfpUrl(String pfpUrl) {
		this.pfpUrl = pfpUrl;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public String getPfpFile() {
		return pfpFile;
	}

	public void setPfpFile(String pfpFile) {
		this.pfpFile = pfpFile;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, phoneNumber, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", city=" + city
				+ ", pfpUrl=" + pfpUrl + ", pfpFile=" + pfpFile + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}