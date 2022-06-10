package team2.api.mobile.gplx.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import team2.api.mobile.gplx.models.TrafficSignType;

@Repository
public interface TrafficSignTypeRepository extends MongoRepository<TrafficSignType, String> {

	TrafficSignType findByName(String name);

	TrafficSignType findByCode(String code);

}
