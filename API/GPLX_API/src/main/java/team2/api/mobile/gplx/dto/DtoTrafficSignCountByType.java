package team2.api.mobile.gplx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoTrafficSignCountByType {
	@JsonProperty("id")
	private String id;
	@JsonProperty("code")
	private String code;
	@JsonProperty("name")
	private String name;
	@JsonProperty("quantity")
	private int quantity;

	public DtoTrafficSignCountByType() {
		super();
	}

	public DtoTrafficSignCountByType(String id, String code, String name, int quantity) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
