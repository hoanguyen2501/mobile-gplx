package team2.api.mobile.gplx.service.interfaces;

import java.util.List;

import team2.api.mobile.gplx.commondata.GenericService;
import team2.api.mobile.gplx.models.QuestionSet;

public interface QuestionSetService extends GenericService<QuestionSet, String> {

	QuestionSet update(QuestionSet set, String id);

	List<QuestionSet> findByLicenseId(String id);

}
