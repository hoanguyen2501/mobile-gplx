package team2.mobileapp.gplx.Retrofit.dto;


import team2.mobileapp.gplx.Retrofit.models.Answer;
import team2.mobileapp.gplx.Retrofit.models.Question;

public class QuestionDetails {
   private Question question;
   private Answer answer;

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

    @Override
    public String toString() {
        return "QuestionDetails{" +
                "question=" + question +
                ", answer=" + answer +
                '}';
    }
}
