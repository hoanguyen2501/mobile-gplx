package team2.api.mobile.gplx.models;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import team2.api.mobile.gplx.commondata.model.AbstractEntity;

@Document
@Getter
@Setter
public class Question extends AbstractEntity {
	
	@JsonProperty("Index")
	private int index;
	
	@JsonProperty("Query")
	private String query;
	
	@JsonProperty("Photo")
	private String photo;
	
	@JsonProperty("LicenseId")
	private String licenseId;
	
	@JsonProperty("QuestionSetId")
	private String questionSetId;
	
	@JsonProperty("QuestionTypeId")
	private String questionTypeId;
	
	public Question(int index, String query, String photo, String licenseId,String questionSetId, String questionTypeId) {
		super();
		this.index = index;
		this.query = query;
		this.photo = photo;
		this.licenseId = licenseId;
		this.questionSetId = questionSetId;
		this.questionTypeId = questionTypeId;
	}

	public Question() {
		
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public String getQuestionSetId() {
		return questionSetId;
	}

	public void setQuestionSetId(String questionSetId) {
		this.questionSetId = questionSetId;
	}

	public String getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(String questionTypeId) {
		this.questionTypeId = questionTypeId;
	}
	
	

}
