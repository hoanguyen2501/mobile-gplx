package team2.api.mobile.gplx.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import team2.api.mobile.gplx.models.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
	Optional<Account> findByUsernameAndPassword(String username, String password);
	Optional<Account> findByUsername(String username);
}
