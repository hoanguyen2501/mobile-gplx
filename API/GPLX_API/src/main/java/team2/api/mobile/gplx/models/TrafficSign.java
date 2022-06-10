package team2.api.mobile.gplx.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import team2.api.mobile.gplx.commondata.model.AbstractEntity;

@Document
@Getter
@Setter
public class TrafficSign extends AbstractEntity {
	
	@Indexed(unique = true)
	@JsonProperty("Code")
	private String code;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("Photo")
	private String photo;
	
	@JsonProperty("TrafficSignType")
	private String trafficSignType;
	
	public TrafficSign(String code, String name, String description, String photo, String trafficSignType) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.photo = photo;
		this.trafficSignType = trafficSignType;
	}
	public TrafficSign() {
		
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getTrafficSignType() {
		return trafficSignType;
	}
	public void setTrafficSignType(String trafficSignType) {
		this.trafficSignType = trafficSignType;
	}
	
}
