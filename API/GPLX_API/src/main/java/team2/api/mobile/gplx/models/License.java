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
public class License extends AbstractEntity {
	
	@Indexed(unique = true)
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Status")
	private Status status;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("LicenseTypeId")
	private String licenseTypeId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public License(String name, Status status, String description, String licenseTypeId) {
		super();
		this.name = name;
		this.status = status;
		this.description = description;
		this.licenseTypeId = licenseTypeId;
	}
	public License() {
		
	}
	public String getLicenseTypeId() {
		return licenseTypeId;
	}
	public void setLicenseTypeId(String licenseTypeId) {
		this.licenseTypeId = licenseTypeId;
	}
	
	
}
