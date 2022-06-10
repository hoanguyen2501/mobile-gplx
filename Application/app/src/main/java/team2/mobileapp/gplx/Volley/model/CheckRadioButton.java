package team2.mobileapp.gplx.Volley.model;

import java.io.Serializable;

public class CheckRadioButton implements Serializable {
    private String questionId;
    private int questionIndex;
    private int radioButtonId;
    private String answerId;
    private int answerIndex;
    private String answerValue;

    public CheckRadioButton(){}

    public CheckRadioButton(String questionId, int questionIndex, int radioButtonId, String answerId, int answerIndex, String answerValue) {
        this.questionId = questionId;
        this.questionIndex = questionIndex;
        this.radioButtonId = radioButtonId;
        this.answerId = answerId;
        this.answerIndex = answerIndex;
        this.answerValue = answerValue;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public int getQuestionIndex() {
        return questionIndex;
    }

    public void setQuestionIndex(int questionIndex) {
        this.questionIndex = questionIndex;
    }

    public int getRadioButtonId() {
        return radioButtonId;
    }

    public void setRadioButtonId(int radioButtonId) {
        this.radioButtonId = radioButtonId;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        this.answerIndex = answerIndex;
    }

    public String getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "CheckRadioButton{" +
                "questionId='" + questionId + '\'' +
                ", questionIndex=" + questionIndex +
                ", radioButtonId=" + radioButtonId +
                ", answerId='" + answerId + '\'' +
                ", answerIndex=" + answerIndex +
                ", answerValue='" + answerValue + '\'' +
                '}';
    }
}
