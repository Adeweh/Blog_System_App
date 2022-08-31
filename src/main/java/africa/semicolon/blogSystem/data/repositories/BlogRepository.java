package africa.semicolon.blogSystem.data.repositories;

import africa.semicolon.blogSystem.data.models.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog, String> {
}
