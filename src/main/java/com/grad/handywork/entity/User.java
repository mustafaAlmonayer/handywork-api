package com.grad.handywork.entity;

import java.util.List;
import java.util.Objects;

import org.springframework.web.multipart.MultipartFile;

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
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username")
	@NotNull(message = "Username Field Cannot Be Empty")
	@Size(min = 4, max = 36, message = "Username Field Must Be Between 4 And 36")
	private String username;

	@Column(name = "password")
	@NotNull(message = "Password Field Cannot Be Empty")
	@Size(min = 8, max = 36, message = "Password Field Must Be Between 8 and 36")
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
	private String email;

	@Column(name = "phone_number")
	@NotEmpty(message = "Phone Number Field Cannot be empty")
	@Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number")
	private String phoneNumber;

	@Column(name = "profile_picture")
	private String pfpUrl;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Job> jobs;
	
	@Transient
	private MultipartFile pfpFile;

	public User() {
		super();
	}

	public User(
			Long id,
			String username,
			String password,
			String firstName,
			String lastName,
			String email,
			String phoneNumber,
			String pfpUrl,
			List<Job> jobs,
			MultipartFile pfpFile
			) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public MultipartFile getPfpFile() {
		return pfpFile;
	}

	public void setPfpFile(MultipartFile pfpFile) {
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
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		jobs.forEach(job -> {
			buffer.append(job.getId());
			buffer.append(", ");
		});
		buffer.append("]");
		
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", pfpUrl=" + pfpUrl
				+ ", jobs=" + jobs + ", pfpFile=" + pfpFile + "]";
	}
	
}