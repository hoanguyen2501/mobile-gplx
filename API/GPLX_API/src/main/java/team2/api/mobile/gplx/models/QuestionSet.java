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
public class QuestionSet extends AbstractEntity {
	
	@JsonProperty("Name")
	@Indexed(unique = true)
	private String name;
	
	@JsonProperty("Status")
	private boolean status;
	
	@JsonProperty("Quantity")
	private int quantity;
	
	@JsonProperty("LicenseId")
	private String licenseId;
	
	
	public QuestionSet(String name, boolean status, int quantity, String licenseId) {
		super();
		this.name = name;
		this.status = status;
		this.quantity = quantity;
		this.licenseId = licenseId;
	}
	public QuestionSet() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}
}
