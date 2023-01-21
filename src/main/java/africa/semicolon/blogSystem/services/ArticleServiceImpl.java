package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.data.models.Article;
import africa.semicolon.blogSystem.data.models.Comment;
import africa.semicolon.blogSystem.data.repositories.ArticleRepository;
import africa.semicolon.blogSystem.dtos.requests.AddArticleRequest;
import africa.semicolon.blogSystem.dtos.requests.DeleteArticleRequest;
import africa.semicolon.blogSystem.dtos.requests.FindArticleRequest;
import africa.semicolon.blogSystem.exceptions.ArticleDoesNotExistsException;
import africa.semicolon.blogSystem.exceptions.ArticleExistsException;
import africa.semicolon.blogSystem.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentService commentService;

    @Override
    public Article addArticle(AddArticleRequest articleRequest) {
        articleExist(articleRequest);

        Article article = new Article();
        Mapper.map(articleRequest, article);

        return articleRepository.save(article);

    }
    private void articleExist(AddArticleRequest request)  {
        Article newArticle = articleRepository.findArticleByTitle(request.getTitle());
        if (newArticle != null && Objects.equals(newArticle.getBlogName(), request.getBlogName())) throw new ArticleExistsException("Article already exists");
    }

    @Override
    public void deleteArticle(DeleteArticleRequest request) {
        Article newArticle = articleRepository.findArticleByTitle(request.getTitle());
        if (newArticle == null) throw new ArticleDoesNotExistsException("Article does not exists");
        else if (Objects.equals(newArticle.getBlogName(), request.getBlogName())){
            for (Comment comment: newArticle.getComments()) {
                commentService.deleteComment(comment);
            }
        }
        articleRepository.delete(newArticle);
    }

    @Override
    public Article viewArticle(FindArticleRequest findArticleRequest) {
        Article newArticle = articleRepository.findArticleByTitle(findArticleRequest.getTitle());
        return newArticle;
    }


}
