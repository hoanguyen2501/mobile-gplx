package team2.api.mobile.gplx.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import team2.api.mobile.gplx.models.HistoricalExam;

@Repository
public interface HistoricalExamRepository extends MongoRepository<HistoricalExam, String> {
	List<HistoricalExam> findByUserId(String userid);

}
