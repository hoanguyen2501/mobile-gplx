package team2.api.mobile.gplx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddLicenseDto {
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Status")
	private String status;
	@JsonProperty("Description")
	private String description;
}
