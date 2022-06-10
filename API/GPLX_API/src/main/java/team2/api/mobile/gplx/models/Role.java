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
public class Role extends AbstractEntity {
	
	@Indexed(unique = true)
	@JsonProperty("RoleName")
	private String roleName;
	
	@JsonProperty("Description")
	private String description;
	
	public Role(String roleName, String description) {
		super();
		this.roleName = roleName;
		this.description = description;
	}
	public Role() {
		
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
