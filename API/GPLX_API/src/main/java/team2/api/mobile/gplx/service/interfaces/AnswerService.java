package team2.api.mobile.gplx.service.interfaces;


import team2.api.mobile.gplx.commondata.GenericService;
import team2.api.mobile.gplx.models.Answer;

public interface AnswerService extends GenericService<Answer, String> {
	Answer update(Answer answer, String id);
	Answer findByQuestionId(String id);
}
