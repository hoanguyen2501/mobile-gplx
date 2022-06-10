
package team2.mobileapp.gplx.Volley.model.dto;

import java.io.Serializable;
import java.util.List;

import team2.mobileapp.gplx.Volley.model.Answer;
import team2.mobileapp.gplx.Volley.model.Question;
import team2.mobileapp.gplx.Volley.model.QuestionSet;

public class DtoQuestionSet implements Serializable {
    private QuestionSet questionSet;
    private List<Question> questList;
    private List<Answer> ansList;

    public DtoQuestionSet() {}

    public DtoQuestionSet(QuestionSet questionSet, List<Question> questList, List<Answer> ansList) {
        super();
        this.questionSet = questionSet;
        this.questList = questList;
        this.ansList = ansList;
    }

    public QuestionSet getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(QuestionSet questionSet) {
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

    @Override
    public String toString() {
        return "DtoQuestionSet{" +
                "questionSet=" + questionSet +
                ", questList=" + questList +
                ", ansList=" + ansList +
                '}';
    }
}

