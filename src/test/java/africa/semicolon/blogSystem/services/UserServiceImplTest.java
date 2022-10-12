package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.data.repositories.BlogRepository;
import africa.semicolon.blogSystem.data.repositories.UserRepository;
import africa.semicolon.blogSystem.dtos.requests.CreateBlogRequest;
import africa.semicolon.blogSystem.dtos.requests.LoginUserRequest;
import africa.semicolon.blogSystem.dtos.requests.RegisterUserRequest;
import africa.semicolon.blogSystem.dtos.responses.LoginUserResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
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
        request.setTitle("Building Trust");
        request.setUserName("DeeBee");
        userService.createUserBlog(request);

        assertEquals(1L, blogRepository.count());



    }

}