package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.data.models.Article;
import africa.semicolon.blogSystem.dtos.requests.AddArticleRequest;
import africa.semicolon.blogSystem.dtos.requests.DeleteArticleRequest;
import africa.semicolon.blogSystem.dtos.requests.FindArticleRequest;


public interface ArticleService {

    Article addArticle(AddArticleRequest articleRequest);

    void deleteArticle(DeleteArticleRequest request);

    Article viewArticle(FindArticleRequest findArticleRequest);
}
