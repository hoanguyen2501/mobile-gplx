package team2.api.mobile.gplx.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import team2.api.mobile.gplx.models.TrafficSign;

@Repository
public interface TrafficSignRepository extends MongoRepository<TrafficSign, String> {
	List<TrafficSign> findByTrafficSignType(String trafficSignType);
}