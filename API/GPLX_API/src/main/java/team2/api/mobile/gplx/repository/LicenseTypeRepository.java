package team2.api.mobile.gplx.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import team2.api.mobile.gplx.models.LicenseType;

@Repository
public interface LicenseTypeRepository extends MongoRepository<LicenseType, String> {

	LicenseType findByName(String name);

}
