package team2.api.mobile.gplx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.api.mobile.gplx.commondata.GenericServiceImpl;
import team2.api.mobile.gplx.models.QuestionType;
import team2.api.mobile.gplx.repository.QuestionTypeRepository;
import team2.api.mobile.gplx.service.interfaces.QuestionTypeService;

@Service
public class QuestionTypeServiceImpl extends GenericServiceImpl<QuestionType, String> implements QuestionTypeService {

	@Autowired
	private QuestionTypeRepository repo;

	@Override
	public QuestionType update(QuestionType questionType, String id) {
		try {
			QuestionType updatedQuestionType = repo.findById(id).get();
			updatedQuestionType.setCode(questionType.getCode());
			updatedQuestionType.setName(questionType.getName());
			updatedQuestionType.setDescription(questionType.getDescription());
			return repo.save(updatedQuestionType);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	@Override
	public QuestionType findByCode(String code) {
		try {
			return repo.findByCode(code.toUpperCase());
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
