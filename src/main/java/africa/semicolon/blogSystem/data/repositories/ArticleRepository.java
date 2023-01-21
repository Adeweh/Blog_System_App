package africa.semicolon.blogSystem.data.repositories;

import africa.semicolon.blogSystem.data.models.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {
    Article findArticleByTitle(String articleName);
}
