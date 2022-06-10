package team2.api.mobile.gplx.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import team2.api.mobile.gplx.models.Question;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {

	List<Question> findByQuestionSetId(String id);
	
	List<Question> findByLicenseId(String licenseid);

}
