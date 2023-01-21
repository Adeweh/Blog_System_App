package africa.semicolon.blogSystem.data.repositories;

import africa.semicolon.blogSystem.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUserName(String username);

}
