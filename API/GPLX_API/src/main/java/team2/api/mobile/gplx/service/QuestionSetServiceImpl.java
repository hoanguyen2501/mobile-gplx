package team2.api.mobile.gplx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.api.mobile.gplx.commondata.GenericServiceImpl;
import team2.api.mobile.gplx.models.QuestionSet;
import team2.api.mobile.gplx.repository.QuestionSetRepository;
import team2.api.mobile.gplx.service.interfaces.QuestionSetService;

@Service
public class QuestionSetServiceImpl extends GenericServiceImpl<QuestionSet, String> implements QuestionSetService {
	@Autowired
	private QuestionSetRepository repo;

	@Override
	public QuestionSet update(QuestionSet set, String id) {
		try {
			QuestionSet updatedSet = repo.findById(id).get();
			updatedSet.setName(set.getName());
			updatedSet.setQuantity(set.getQuantity());
			return repo.save(updatedSet);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public List<QuestionSet> findByLicenseId(String id) {
		return repo.findByLicenseId(id);
	}
}
