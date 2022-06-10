package team2.api.mobile.gplx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.api.mobile.gplx.commondata.GenericServiceImpl;
import team2.api.mobile.gplx.models.License;
import team2.api.mobile.gplx.models.Question;
import team2.api.mobile.gplx.repository.LicenseRepository;
import team2.api.mobile.gplx.repository.QuestionRepository;
import team2.api.mobile.gplx.service.interfaces.QuestionService;

@Service
public class QuestionServiceImpl extends GenericServiceImpl<Question, String> implements QuestionService{
	@Autowired
	private QuestionRepository repo;
	@Autowired
	private LicenseRepository licenseRepo;

	@Override
	public Question update(Question question, String id) {
		try {
			Question updatedQuestion = repo.findById(id).get();
			updatedQuestion.setIndex(question.getIndex());
			updatedQuestion.setQuery(question.getQuery());
			updatedQuestion.setPhoto(question.getPhoto());
			updatedQuestion.setLicenseId(question.getLicenseId());
			updatedQuestion.setQuestionSetId(question.getQuestionSetId());
			updatedQuestion.setQuestionTypeId(question.getQuestionTypeId());
			return repo.save(updatedQuestion);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public List<Question> findByQuestionSetId(String id) {
		return repo.findByQuestionSetId(id);
	}
	
	@Override
	public List<Question> findQuestionByLicense(String licenseName) {
		License license = licenseRepo.findByName(licenseName.toUpperCase());
		return repo.findByLicenseId(license.getId());
	}

	@Override
	public List<Question> findQuestionByLicenseId(String id) {
		return repo.findByLicenseId(id);
	}
}
