package team2.api.mobile.gplx.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import team2.api.mobile.gplx.commondata.model.AbstractEntity;

@Document
@Getter
@Setter
public class Account extends AbstractEntity {
	
	@Indexed(unique = true)
	@JsonProperty("Username")
	private String username;
	
	@JsonProperty("Password")
	private String password;
	
	@Indexed(unique = true)
	@JsonProperty("Email")
	private String email;
	
	@JsonProperty("FullName")
	private String fullName;
	
	@JsonProperty("Avatar")
	private String avatar;
	
	@JsonProperty("Status")
	private AccountStatus status;
	
	private String roleId;

	public Account() {
		super();
	}

	public Account(String username, String password, String email, String fullName, String avatar, AccountStatus status,
			String roleId) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullName = fullName;
		this.avatar = avatar;
		this.status = status;
		this.roleId = roleId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
