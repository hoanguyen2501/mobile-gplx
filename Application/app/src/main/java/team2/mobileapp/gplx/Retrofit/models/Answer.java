package team2.mobileapp.gplx.Retrofit.models;

import java.util.Arrays;

public class Answer {
    private String id;
    private String[] AnswerName;
    private int Result;
    private String QuestionId;

    public Answer() {
    }

    public Answer(String[] answerName, int result, String questionId) {
        super();
        this.AnswerName = answerName;
        this.Result = result;
        this.QuestionId = questionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getAnswerName() {
        return AnswerName;
    }

    public String getAnswerByIndex(int i) {
        try {
            return AnswerName[i];
        }
        catch (Exception ex)
        {
            return "No result";
        }

    }

    public void setAnswerName(String[] answerName) {
        this.AnswerName = answerName;
    }

    public int getResult() {
        return Result;
    }

    public void setResult(int result) {
        this.Result = result;
    }

    public String getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(String questionId) {
        this.QuestionId = questionId;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id='" + id + '\'' +
                ", answerList=" + Arrays.toString(AnswerName) +
                ", result=" + Result +
                ", questionId='" + QuestionId + '\'' +
                '}';
    }
}
