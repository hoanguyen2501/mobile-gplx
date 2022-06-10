package team2.mobileapp.gplx.Volley.model;

import java.io.Serializable;
import java.util.Arrays;

public class Answer implements Serializable {
    private String id;
    private String[] answerList;
    private int result;
    private String questionId;

    public Answer() {
    }

    public Answer(String[] answerList, int result, String questionId) {
        super();
        this.answerList = answerList;
        this.result = result;
        this.questionId = questionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Answer{" +
                "id='" + id + '\'' +
                ", answerList=" + Arrays.toString(answerList) +
                ", result=" + result +
                ", questionId='" + questionId + '\'' +
                '}';
    }
}
