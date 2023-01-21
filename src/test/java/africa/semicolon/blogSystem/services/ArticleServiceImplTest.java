package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.data.models.Article;
import africa.semicolon.blogSystem.data.repositories.ArticleRepository;
import africa.semicolon.blogSystem.dtos.requests.*;
import africa.semicolon.blogSystem.dtos.responses.FindArticleResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleServiceImplTest {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRepository articleRepository;

    private AddArticleRequest articleRequest;

    @BeforeEach
    void setUp() {
        articleRequest=new AddArticleRequest();
        articleRequest.setBlogName("Diary of Ade");
        articleRequest.setTitle("Becoming Truth");
        articleRequest.setUserName("DeeBee");
        articleRequest.setBody("Today we will be talking about the Truth of God's word");
    }

    @AfterEach
    void tearDown(){
        articleRepository.deleteAll();
    }
    @Test
    void addArticleTest() {
        articleService.addArticle(articleRequest);

        assertEquals(1L, articleRepository.count());

        assertThat(articleRepository.count(), is(1L));
    }
    @Test
    void deleteArticleTest(){

        AddArticleRequest articleRequest1 = new AddArticleRequest();
        articleRequest1.setBlogName("Diary of Ade");
        articleRequest1.setTitle("Love and Lies");
        articleRequest1.setUserName("DeeBee");
        articleRequest1.setBody("They say believe in love but interesting how lie sits right in the middle");

        articleService.addArticle(articleRequest);
        articleService.addArticle(articleRequest1);

        DeleteArticleRequest deleteRequest = new DeleteArticleRequest();
        deleteRequest.setTitle("Love and Lies");
        deleteRequest.setBlogName("Diary of Ade");
        deleteRequest.setUserName("DeeBee");

        articleService.deleteArticle(deleteRequest);

        assertEquals(1L, articleRepository.count());
        assertThat(articleRepository.count(), is(1L));

    }
    @Test
    void viewArticleTest(){

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

        articleService.addArticle(articleRequest);
        articleService.addArticle(articleRequest1);

        FindArticleRequest findArticle = new FindArticleRequest();
        findArticle.setBlogName("Diary of Ade");
        findArticle.setTitle("Becoming Truth");
        findArticle.setUserName("DeeBee");

        Article response = articleService.viewArticle(findArticle);

        assertEquals("Today we will be talking about the Truth of God's word", response.getBody());
        assertThat(response.getBody(), is("Today we will be talking about the Truth of God's word"));
    }
}