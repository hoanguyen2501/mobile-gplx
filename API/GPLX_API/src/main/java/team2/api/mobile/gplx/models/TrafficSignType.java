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
public class TrafficSignType extends AbstractEntity {
	
	@Indexed(unique = true)
	@JsonProperty("Code")
	private String code;
	
	@JsonProperty("Name")
	private String name;

	public TrafficSignType(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public TrafficSignType() {
		
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
	
}
