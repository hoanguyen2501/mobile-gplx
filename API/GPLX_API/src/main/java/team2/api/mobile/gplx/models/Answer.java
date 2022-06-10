package team2.api.mobile.gplx.models;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import team2.api.mobile.gplx.commondata.model.AbstractEntity;


@Document
@Getter
@Setter
public class Answer extends AbstractEntity {
	@JsonProperty("AnswerName")
	private String[] answerList;
	
	@JsonProperty("Result")
	private int result;
	
	@JsonProperty("QuestionId")
	private String questionId;
	
	public Answer() {
		
	}

	public Answer(String[] answerList, int result, String questionId) {
		super();
		this.answerList = answerList;
		this.result = result;
		this.questionId = questionId;
	}

	public String[] getAnswerList() {
		return answerList;
	}

	public void setAnswerList(String[] answerList) {
		this.answerList = answerList;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
}
