package chnu.edu.websecurity26.user;

/*
  @author   nzon
  @project   web-security26
  @class  UserRepository
  @version  1.0.0 
  @since 08/11/2026 - 10.31
*/

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
