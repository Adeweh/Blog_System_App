package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.data.models.Article;
import africa.semicolon.blogSystem.data.models.Blog;
import africa.semicolon.blogSystem.data.repositories.BlogRepository;
import africa.semicolon.blogSystem.dtos.requests.AddArticleRequest;
import africa.semicolon.blogSystem.dtos.requests.CreateBlogRequest;
import africa.semicolon.blogSystem.dtos.requests.DeleteArticleRequest;
import africa.semicolon.blogSystem.dtos.requests.FindArticleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private  ArticleService articleService;
    @Override
    public Blog createBlog(CreateBlogRequest request) {
        Blog blog = new Blog();
        blog.setTitle(request.getName());
        return blogRepository.save(blog);
    }
    @Override
    public Article addArticle(AddArticleRequest articleRequest) {
        Article newArticle = articleService.addArticle(articleRequest);
        Blog blog = blogRepository.findBlogsByTitle(articleRequest.getBlogName());

        blog.getArticles().add(newArticle);
        blogRepository.save(blog);

        return newArticle;
    }

    @Override
    public void deleteArticle(DeleteArticleRequest request) {
        articleService.deleteArticle(request);

    }

    @Override
    public Article viewArticle(FindArticleRequest findArticleRequest) {
        Article newArticle = articleService.viewArticle(findArticleRequest);
        return newArticle ;
    }
}
