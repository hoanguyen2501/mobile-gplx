package team2.api.mobile.gplx.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import team2.api.mobile.gplx.models.License;

@Repository
public interface LicenseRepository extends MongoRepository<License, String> {
	License findByName(String name);
}

