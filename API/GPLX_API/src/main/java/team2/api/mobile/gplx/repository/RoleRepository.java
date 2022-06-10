package team2.api.mobile.gplx.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import team2.api.mobile.gplx.models.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
	Role findByRoleName(String roleName);
}
