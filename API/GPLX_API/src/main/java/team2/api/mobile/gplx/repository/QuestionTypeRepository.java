package team2.api.mobile.gplx.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import team2.api.mobile.gplx.models.QuestionType;

@Repository
public interface QuestionTypeRepository extends MongoRepository<QuestionType, String> {
	QuestionType findByCode(String code);
}
