package team2.api.mobile.gplx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import team2.api.mobile.gplx.models.Answer;
import team2.api.mobile.gplx.models.Question;

public class DtoQuestionDetail {
	@JsonProperty("question")
	private Question question;
	@JsonProperty("answer")
	private Answer answer;

	public DtoQuestionDetail() {
	}

	public DtoQuestionDetail(Question question, Answer answer) {
		this.question = question;
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

}