package team2.api.mobile.gplx.service.interfaces;

import java.util.List;

import team2.api.mobile.gplx.commondata.GenericService;
import team2.api.mobile.gplx.models.Question;

public interface QuestionService extends GenericService<Question, String> {

	Question update(Question question, String id);

	List<Question> findByQuestionSetId(String id);
	
	List<Question> findQuestionByLicense(String license);

	List<Question> findQuestionByLicenseId(String id);

}
