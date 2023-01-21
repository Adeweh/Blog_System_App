package africa.semicolon.blogSystem.data.repositories;

import africa.semicolon.blogSystem.data.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
