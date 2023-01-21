package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.data.repositories.ArticleRepository;
import africa.semicolon.blogSystem.data.repositories.BlogRepository;
import africa.semicolon.blogSystem.data.repositories.UserRepository;
import africa.semicolon.blogSystem.dtos.requests.*;
import africa.semicolon.blogSystem.dtos.responses.FindArticleResponse;
import africa.semicolon.blogSystem.dtos.responses.LoginUserResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @Autowired

    private BlogRepository blogRepository;

    @Autowired
    private ArticleRepository articleRepository;

    private RegisterUserRequest registerUserForm;

    @BeforeEach
    void setUp() {
        registerUserForm = new RegisterUserRequest();
        registerUserForm.setUserName("DeeBee");
        registerUserForm.setEmail("dorcas@gmail.com");
        registerUserForm.setPassword("iLoveJesus222");

    }
    @AfterEach
    void tearDown(){
        userRepository.deleteAll();
        blogRepository.deleteAll();
        articleRepository.deleteAll();
    }

    @Test
    public void registerUser_repositorySizeIsOneTest(){
        userService.registerUser(registerUserForm);

        assertEquals(1L, userRepository.count());

       assertThat(userRepository.count(), is(1L));

    }
    @Test
    public void registeredUser_CanLoginTest(){
        userService.registerUser(registerUserForm);

        LoginUserRequest loginPage = new LoginUserRequest();

        loginPage.setUserName("DeeBee");
        loginPage.setPassword("iLoveJesus222");
        LoginUserResponse response = userService.loginUser(loginPage);

        assertEquals("Logged in successfully. Welcome back!", response.getMessage());
        assertThat(userService.loginUser(loginPage).getMessage(), is("Logged in successfully. Welcome back!"));

    }
    @Test
    public void userCanCreateBlogTest(){
        userService.registerUser(registerUserForm);

        LoginUserRequest loginPage = new LoginUserRequest();

        loginPage.setUserName("DeeBee");
        loginPage.setPassword("iLoveJesus222");

        CreateBlogRequest request = new CreateBlogRequest();
        request.setName("Building Trust");
        request.setUserName("DeeBee");
        userService.createUserBlog(request);

        assertEquals(1L, blogRepository.count());
        assertThat(blogRepository.count(), is(1L));

    }
    @Test
    public void userCanAddArticleToBlogTest(){
        userService.registerUser(registerUserForm);

        LoginUserRequest loginPage = new LoginUserRequest();

        loginPage.setUserName("DeeBee");
        loginPage.setPassword("iLoveJesus222");

        CreateBlogRequest request = new CreateBlogRequest();
        request.setName("Diary of Ade");
        request.setUserName("DeeBee");
        userService.createUserBlog(request);

        AddArticleRequest articleRequest = new AddArticleRequest();
        articleRequest.setBlogName("Diary of Ade");
        articleRequest.setTitle("Becoming Truth");
        articleRequest.setUserName("DeeBee");
        articleRequest.setBody("Today we will be talking about the Truth of God's word");

        userService.addArticle(articleRequest);

        assertThat(articleRepository.count(), is(1L));
        assertEquals(1L, articleRepository.count());

    }
    @Test
    public void userCanDeleteArticleFromBlogTest(){
        userService.registerUser(registerUserForm);

        LoginUserRequest loginPage = new LoginUserRequest();

        loginPage.setUserName("DeeBee");
        loginPage.setPassword("iLoveJesus222");

        CreateBlogRequest request = new CreateBlogRequest();
        request.setName("Diary of Ade");
        request.setUserName("DeeBee");
        userService.createUserBlog(request);

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

        userService.addArticle(articleRequest);
        userService.addArticle(articleRequest1);

        DeleteArticleRequest deleteRequest = new DeleteArticleRequest();
        deleteRequest.setTitle("Love and Lies");
        deleteRequest.setBlogName("Diary of Ade");
        deleteRequest.setUserName("DeeBee");

        userService.deleteArticle(deleteRequest);

        assertThat(articleRepository.count(), is(1L));
        assertEquals(1L, articleRepository.count());


    }
    @Test
    public void userCanViewAnArticleFromBlogTest() {
        userService.registerUser(registerUserForm);

        LoginUserRequest loginPage = new LoginUserRequest();

        loginPage.setUserName("DeeBee");
        loginPage.setPassword("iLoveJesus222");

        CreateBlogRequest request = new CreateBlogRequest();
        request.setName("Diary of Ade");
        request.setUserName("DeeBee");
        userService.createUserBlog(request);

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

        userService.addArticle(articleRequest);
        userService.addArticle(articleRequest1);

        FindArticleRequest findArticle = new FindArticleRequest();
        findArticle.setBlogName("Diary of Ade");
        findArticle.setTitle("Becoming Truth");
        findArticle.setUserName("DeeBee");

        FindArticleResponse response = userService.viewArticle(findArticle);

        assertEquals("Today we will be talking about the Truth of God's word", response.getBody());
        assertThat(response.getBody(), is("Today we will be talking about the Truth of God's word"));

    }
    @Test
    public void userCanViewAllArticlesTest(){
        userService.registerUser(registerUserForm);

        LoginUserRequest loginPage = new LoginUserRequest();

        loginPage.setUserName("DeeBee");
        loginPage.setPassword("iLoveJesus222");

        CreateBlogRequest request = new CreateBlogRequest();
        request.setName("Diary of Ade");
        request.setUserName("DeeBee");
        userService.createUserBlog(request);

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

        userService.addArticle(articleRequest);
        userService.addArticle(articleRequest1);

//        assertThat();

    }
}