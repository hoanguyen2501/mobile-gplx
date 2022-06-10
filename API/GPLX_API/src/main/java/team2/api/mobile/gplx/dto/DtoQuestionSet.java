package team2.api.mobile.gplx.dto;


import java.util.List;
import java.util.Optional;

import team2.api.mobile.gplx.models.Answer;
import team2.api.mobile.gplx.models.Question;
import team2.api.mobile.gplx.models.QuestionSet;

public class DtoQuestionSet {
	private Optional<QuestionSet> questionSet;
	private List<Question> questList;
	private List<Answer> ansList;
	
	public DtoQuestionSet() {}

	public DtoQuestionSet(Optional<QuestionSet> questionSet, List<Question> questList, List<Answer> ansList) {
		super();
		this.questionSet = questionSet;
		this.questList = questList;
		this.ansList = ansList;
	}

	public Optional<QuestionSet> getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(Optional<QuestionSet> questionSet) {
		this.questionSet = questionSet;
	}

	public List<Question> getQuestList() {
		return questList;
	}

	public void setQuestList(List<Question> questList) {
		this.questList = questList;
	}

	public List<Answer> getAnsList() {
		return ansList;
	}

	public void setAnsList(List<Answer> ansList) {
		this.ansList = ansList;
	}
	
}
