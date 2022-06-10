package team2.api.mobile.gplx.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import team2.api.mobile.gplx.models.Answer;

@Repository
public interface AnswerRepository extends MongoRepository<Answer, String> {
	Answer findByQuestionId(String id);
}
