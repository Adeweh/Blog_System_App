package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.data.repositories.UserRepository;
import africa.semicolon.blogSystem.dtos.requests.CreateBlogRequest;
import africa.semicolon.blogSystem.dtos.requests.LoginUserRequest;
import africa.semicolon.blogSystem.dtos.requests.RegisterUserRequest;
import africa.semicolon.blogSystem.dtos.responses.LoginUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserRepository userRepository;

    private LoginUserResponse loginUser;

    @BeforeEach
    void setUp() {
        RegisterUserRequest registerUserForm = new RegisterUserRequest();
        registerUserForm.setEmail("dorcas@gmail.com");
        registerUserForm.setPassword("iLoveJesus222");
        userService.registerUser(registerUserForm);

        LoginUserRequest loginPage = new LoginUserRequest();

        loginPage.setEmail("dorcas@gmail.com");
        loginPage.setPassword("iLoveJesus222");
        loginUser = userService.loginUser(loginPage);

    }

    @Test
    public void registerUser_repositorySizeIsOneTest(){
        //given that i have a register form
        //RegisterUserRequest registerUserForm = new RegisterUserRequest();
        //when i try to register
        //registerUserForm.setEmail("dorcas");
        //registerUserForm.setPassword("iLoveJesus222");
       // userService.registerUser(registerUserForm);
        //check that repository size has increased
        assertEquals(1L, userRepository.count());
      //  assertThat(userRepository.count(), is(1l));

    }
    @Test
    public void registeredUser_CanLogin(){
        /*RegisterUserRequest registerUserForm = new RegisterUserRequest();
        registerUserForm.setEmail("dorcas@gmail.com");
        registerUserForm.setPassword("iLoveJesus222");
        userService.registerUser(registerUserForm);

        LoginUserRequest loginPage = new LoginUserRequest();

        loginPage.setEmail("dorcas@gmail.com");
        loginPage.setPassword("iLoveJesus222");*/

        assertEquals("Logged in successfully. Welcome back!", loginUser.getMessage());

    }
    @Test
    public void createBlog_repositorySizeIsOneTest(){
        CreateBlogRequest blogRequest = new CreateBlogRequest();
        blogRequest.setTitle("Truth");
        blogRequest.setDescription("Christ is Truth");
        //blogRequest.setUserId();
        assertEquals(1, blogService.getAllBlog().size());



    }

}