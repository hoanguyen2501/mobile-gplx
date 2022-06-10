package team2.api.mobile.gplx.service.interfaces;

import team2.api.mobile.gplx.commondata.GenericService;
import team2.api.mobile.gplx.models.QuestionType;

public interface QuestionTypeService extends GenericService<QuestionType, String> {
	QuestionType update(QuestionType questionType, String id);
	QuestionType findByCode(String code);
}
