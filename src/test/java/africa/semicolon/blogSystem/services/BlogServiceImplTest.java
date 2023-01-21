package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.data.models.Article;
import africa.semicolon.blogSystem.data.repositories.ArticleRepository;
import africa.semicolon.blogSystem.data.repositories.BlogRepository;
import africa.semicolon.blogSystem.dtos.requests.AddArticleRequest;
import africa.semicolon.blogSystem.dtos.requests.CreateBlogRequest;
import africa.semicolon.blogSystem.dtos.requests.DeleteArticleRequest;
import africa.semicolon.blogSystem.dtos.requests.FindArticleRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BlogServiceImplTest {
    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ArticleRepository articleRepository;

    private CreateBlogRequest request;

    @BeforeEach
    void setUp() {
        request = new CreateBlogRequest();
        request.setUserName("DeeBee");
        request.setName("Diary of Ade");
    }

    @AfterEach
    void tearDown() {
        blogRepository.deleteAll();
        articleRepository.deleteAll();
    }

    @Test
    void createBlogTest() {
        blogService.createBlog(request);

        assertEquals(1L, blogRepository.count());

        assertThat(blogRepository.count(), is(1L));

    }

    @Test
    void addArticleTest() {
        blogService.createBlog(request);

        AddArticleRequest articleRequest = new AddArticleRequest();
        articleRequest.setBlogName("Diary of Ade");
        articleRequest.setTitle("Becoming Truth");
        articleRequest.setUserName("DeeBee");
        articleRequest.setBody("Today we will be talking about the Truth of God's word");

        blogService.addArticle(articleRequest);

        assertThat(articleRepository.count(), is(1L));
        assertEquals(1L, articleRepository.count());

    }
    @Test
    void deleteArticleTest(){
        blogService.createBlog(request);

        AddArticleRequest articleRequest = new AddArticleRequest();
        articleRequest.setBlogName("Diary of Ade");
        articleRequest.setTitle("Becoming Truth");
        articleRequest.setUserName("DeeBee");
        articleRequest.setBody("Today we will be talking about the Truth of God's word");
        blogService.addArticle(articleRequest);

        DeleteArticleRequest deleteRequest = new DeleteArticleRequest();
        deleteRequest.setTitle("Becoming Truth");
        deleteRequest.setUserName("DeeBee");
        deleteRequest.setBlogName("Diary of Ade");

        blogService.deleteArticle(deleteRequest);

        assertThat(articleRepository.count(), is(0L));
        assertEquals(0L, articleRepository.count());

    }
    @Test
    void viewAnArticleTest(){
        blogService.createBlog(request);

        AddArticleRequest articleRequest = new AddArticleRequest();
        articleRequest.setBlogName("Diary of Ade");
        articleRequest.setTitle("Becoming Truth");
        articleRequest.setUserName("DeeBee");
        articleRequest.setBody("Today we will be talking about the Truth of God's word");

        AddArticleRequest articleRequest1 = new AddArticleRequest();
        articleRequest1.setBlogName("Diary of Ade");
        articleRequest1.setTitle("Love and Lies");
        articleRequest1.setUserName("DeeBee");
        articleRequest1.setBody("They say believe in love but interesting how lie sits right in the middle");

        blogService.addArticle(articleRequest);
        blogService.addArticle(articleRequest1);

        FindArticleRequest findArticle = new FindArticleRequest();
        findArticle.setBlogName("Diary of Ade");
        findArticle.setTitle("Becoming Truth");
        findArticle.setUserName("DeeBee");

        Article response = blogService.viewArticle(findArticle);

        assertEquals("Today we will be talking about the Truth of God's word", response.getBody());
        assertThat(response.getBody(), is("Today we will be talking about the Truth of God's word"));

    }
}